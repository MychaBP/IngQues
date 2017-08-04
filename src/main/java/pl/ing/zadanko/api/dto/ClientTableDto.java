package pl.ing.zadanko.api.dto;


public class ClientTableDto {

    Integer clientNr;
    String name;
    String region;
    String branza;

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
