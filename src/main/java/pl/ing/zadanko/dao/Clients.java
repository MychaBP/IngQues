package pl.ing.zadanko.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Clients {

    @Id
    @GeneratedValue
    Integer id;

    @Column(name = "CLIENT_NR")
    Integer clientNr;

    @Column(name = "NAME")
    String name;

    @Column(name = "REGION")
    String region;

    @Column(name = "PHONE_NUMBER")
    String phoneNumber;

    @Column(name = "BRANZA")
    String branza;

    @Column(name = "EMAIL")
    String email;

    @Column(name = "ACTIVITY_FROM")
    Timestamp activityFrom;

    @Column(name = "CREATE_AT")
    Timestamp createAt;

    @Column(name = "LAST_MODIFY")
    Timestamp lastModify;

    @OneToMany(mappedBy = "client")
    List<Notes> notes;

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

    public Timestamp getActivityFrom() {
        return activityFrom;
    }

    public void setActivityFrom(Timestamp activityFrom) {
        this.activityFrom = activityFrom;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Timestamp getLastModify() {
        return lastModify;
    }

    public void setLastModify(Timestamp lastModify) {
        this.lastModify = lastModify;
    }

    public List<Notes> getNotes() {
        return notes;
    }

    public void setNotes(List<Notes> notes) {
        this.notes = notes;
    }
}
