package com.senchuk.project.model;


import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public User(String name) {
        this.name = name;
    }

    public User() {
    }
}

