package com.example.homework10;

import lombok.Data;

@Data
public class User {
    String role;
    String name;

    public User(String name, String role) {
        this.role = role;
        this.name = name;
    }
}
