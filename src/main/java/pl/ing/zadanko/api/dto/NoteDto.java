package pl.ing.zadanko.api.dto;

public class NoteDto {
    Integer Id;
    Integer clientNr;
    String name;
    String text;

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
}
