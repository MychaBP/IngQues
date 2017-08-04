package pl.ing.zadanko.api.dto;

import java.sql.Timestamp;
import java.time.LocalDate;

public class ClientFullDto {
    Integer clientNr;
    String name;
    String region;
    String phoneNumber;
    String branza;
    String email;
    LocalDate activityFrom;

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

    public LocalDate getActivityFrom() {
        return activityFrom;
    }

    public void setActivityFrom(LocalDate activityFrom) {
        this.activityFrom = activityFrom;
    }
}
