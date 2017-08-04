package pl.ing.zadanko.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.ing.zadanko.Services.NoteService;
import pl.ing.zadanko.api.dto.NotesDto;

@RestController
@RequestMapping("/notes")
public class NotesApi {

    NoteService noteService;

    @Autowired
    NotesApi(NoteService noteService) {
        this.noteService = noteService;
    }


    @GetMapping("/clientNotes")
    public NotesDto getNotesForClient(@Param("clientNr") Integer clientNr) {
            return noteService.getNotesForClient(clientNr);
    }

}
