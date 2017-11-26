package pl.ing.zadanko.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.ing.zadanko.api.dto.NoteBlockDto;
import pl.ing.zadanko.api.dto.NoteDto;
import pl.ing.zadanko.services.NoteService;
import pl.ing.zadanko.api.dto.NotesDto;

@RestController
@RequestMapping("/notes")
public class NotesApi {

    NoteService noteService;

    @Autowired
    NotesApi(NoteService noteService) {
        this.noteService = noteService;
    }


    @GetMapping("/clientNotes/{clientId}")
    public NotesDto getNotesForClient(@PathVariable("clientId") Integer clientId) {
            return noteService.getNotesForClient(clientId);
    }

    @PostMapping("/save")
    public void save(@RequestBody NoteDto noteDto) {
        noteService.saveOrUpdate(noteDto);
    }

    @GetMapping("/canEdit/{noteId}")
    public boolean canEdit(@PathVariable("noteId") Integer noteId) {
        return noteService.canEdit(noteId);
    }

    @PostMapping("/changeBlockStatus")
    public void changeBlockStatus(@RequestBody NoteBlockDto noteBlockDto) {
        noteService.updateBlockStatus(noteBlockDto);
    }

}
