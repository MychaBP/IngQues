package pl.ing.zadanko.api.dto;


public class ClientsFilterDto {
    private String region;
    private String branza;

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
