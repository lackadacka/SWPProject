package com.rentalsystem.swp.dao;

import lombok.Data;

@Data
public class UserProfileData {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
}
