package pl.ing.zadanko.api.dto;

import java.time.LocalDate;

public class ClientFullDto {
    private Integer clientId;
    private Integer clientNr;
    private String name;
    private String region;
    private String phoneNumber;
    private String branza;
    private String email;
    private String activityFrom;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBranza() {
        return branza;
    }

    public void setBranza(String branza) {
        this.branza = branza;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActivityFrom() {
        return activityFrom;
    }

    public void setActivityFrom(String activityFrom) {
        this.activityFrom = activityFrom;
    }
}
