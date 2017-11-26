package pl.ing.zadanko.api.dto;


import java.util.List;

public class NotesDto {
    private List<NoteDto> notes;

    public List<NoteDto> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteDto> notes) {
        this.notes = notes;
    }
}
