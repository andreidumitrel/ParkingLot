package com.parking.parkinglot1.common;

public class UserDto {

    String name;
    String email;
    Long id;
    String password;

    public UserDto(String username, String email, Long id, String password) {
        this.name = username;
        this.email = email;
        this.id = id;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() { return id; }

    public String getPassword() { return password; }
}
