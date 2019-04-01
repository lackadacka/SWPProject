package com.rentalsystem.swp.POSTResponds;

import lombok.Data;

@Data
public class UserProfileData {
    long id;
    String firstName;
    String lastName;
    String email;
    String password;
    String phoneNumber;

}
