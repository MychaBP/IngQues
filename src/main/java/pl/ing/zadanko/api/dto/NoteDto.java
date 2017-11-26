package pl.ing.zadanko.api.dto;

public class NoteDto {
    private Integer Id;
    private Integer clientNr;
    private String name;
    private String text;
    private Integer parentId;
    private boolean isBlock;



    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getClientNr() {
        return clientNr;
    }

    public void setClientNr(Integer clientNr) {
        this.clientNr = clientNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public boolean isBlock() {
        return isBlock;
    }

    public void setBlock(boolean block) {
        isBlock = block;
    }
}
