package pl.ing.zadanko.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ing.zadanko.api.dto.NoteBlockDto;
import pl.ing.zadanko.api.dto.NoteDto;
import pl.ing.zadanko.api.dto.NotesDto;
import pl.ing.zadanko.dao.Clients;
import pl.ing.zadanko.dao.Notes;
import pl.ing.zadanko.repositiories.NotesRepository;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteService {
    NotesRepository notesRepository;

    @Autowired
    NoteService(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    public NotesDto getNotesForClient(Integer clientId) {
        return prepareNotesDto(notesRepository.findByClient_Id(clientId));
    }

    public Notes saveOrUpdate(NoteDto noteDto) {
        Notes note;
        if(noteDto.getId()!=null) {
            note = updateNote(noteDto);
        } else {
            note = createNewNote(noteDto);
        }
        return notesRepository.save(note);
    }

    public boolean canEdit(Integer noteId) {
        Notes note = notesRepository.findOne(noteId);

        if(note != null ) {
            return !note.isBlock();
        }

        //TODO obsługa błędu

        return true;
    }

    public void updateBlockStatus(NoteBlockDto noteBlockDto) {
        Notes note = notesRepository.findOne(noteBlockDto.getNoteId());

        if(note.isBlock() != noteBlockDto.isBlockStatus()){
            note.setBlock(noteBlockDto.isBlockStatus());
            notesRepository.save(note);
        }
    }

    private Notes updateNote(NoteDto noteDto) {
        Notes note = notesRepository.findOne(noteDto.getId());

        note.setName(noteDto.getName());
        note.setText(noteDto.getText());
        note.setLastModify(Timestamp.valueOf(LocalDateTime.now()));
        note.setBlock(false);

        return note;
    }

    private Notes createNewNote(NoteDto noteDto) {
        Notes note = noteDtoToNote(noteDto);

        note.setCreateAt(Timestamp.valueOf(LocalDateTime.now()));
        note.setBlock(false);

        return note;
    }

    private Notes noteDtoToNote(NoteDto noteDto) {
        Notes note = new Notes();

        note.setId(noteDto.getId());
        note.setName(noteDto.getName());
        note.setText(noteDto.getText());
        note.setClient(new Clients(noteDto.getClientNr()));


        return note;

    }


    private NotesDto prepareNotesDto(List<Notes> notes) {
        NotesDto notesDto = new NotesDto();

        List<NoteDto> noteDtos = notes.stream().map(p -> prepareNoteDto(p)).collect(Collectors.toList());

        notesDto.setNotes(noteDtos);

        return notesDto;
    }

    private NoteDto prepareNoteDto(Notes note) {
        NoteDto noteDto = new NoteDto();

        noteDto.setId(note.getId());
        noteDto.setClientNr(note.getClient().getClientNr());
        noteDto.setName(note.getName());
        noteDto.setText(note.getText());
        noteDto.setBlock(note.isBlock());
        if(note.getParentNote() != null) {
            noteDto.setParentId(note.getParentNote().getId());
        }

        return noteDto;
    }



}
