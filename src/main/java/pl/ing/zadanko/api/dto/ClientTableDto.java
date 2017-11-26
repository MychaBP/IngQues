package pl.ing.zadanko.api.dto;


public class ClientTableDto {

    private Integer id;
    private Integer clientNr;
    private String name;
    private String region;
    private String branza;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getBranza() {
        return branza;
    }

    public void setBranza(String branza) {
        this.branza = branza;
    }
}
