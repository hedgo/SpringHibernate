package com.hedgo.dbtests.model;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User {
    private int id;
    private String name;
    private String country;

    public User() {
    }

    public User(String country, String name) {
        this.country = country;
        this.name = name;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", country=" + country;
    }
}
