package com.uber.chargers.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@Table(name = "charger")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Charger {

    @Id
    @GeneratedValue()
    private long id;

    @Column(nullable = false)
    private String session;

    @Column
    private String status;

    @Column
    private String address;

    @Column
    private String city;

    public Charger() {
    }

    public Charger(String session, String status) {
        this.session = session;
        this.status = status;
    }

    public Charger(String session) {
        this.session = session;
    }

    public Charger(String session, int id, String status) {
        this.session = session;
        this.id = id;
        this.status = status;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Charger {" +
                "id=" + id +
                ", session='" + session + '\'' +
                ", status='" + status + '\'' +
                ", city='" + city + '\'' +
                ", address=" + address +
                '}';
    }
}
