package com.itis.term.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;


@ToString
@Getter
@Setter
@AllArgsConstructor

public class User {
    private Integer id;
    private String email;
    private String password;
    private String userName;
    private Boolean online;
    private ArrayList<Integer> currentPlaces;

    public User(Integer id, String email, String userName, Boolean online) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.online = online;
    }
}

