package pl.ing.zadanko.api.dto;

public class NoteBlockDto {
    public Integer noteId;
    public boolean blockStatus;

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public boolean isBlockStatus() {
        return blockStatus;
    }

    public void setBlockStatus(boolean blockStatus) {
        this.blockStatus = blockStatus;
    }
}
