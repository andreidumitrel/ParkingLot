package com.parking.parkinglot1.common;

public class UserDto {

    String name;
    String email;

    public UserDto(String username, String email) {
        this.name = username;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
