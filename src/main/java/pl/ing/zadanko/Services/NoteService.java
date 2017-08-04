package pl.ing.zadanko.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ing.zadanko.api.dto.NoteDto;
import pl.ing.zadanko.api.dto.NotesDto;
import pl.ing.zadanko.dao.Notes;
import pl.ing.zadanko.repositiories.NotesRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteService {
    NotesRepository notesRepository;

    @Autowired
    NoteService(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    public NotesDto getNotesForClient(Integer clientNr) {
        return prepareNotesDto(notesRepository.findByClientNr(clientNr));
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

        return noteDto;
    }

}
