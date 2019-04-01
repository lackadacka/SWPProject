package com.rentalsystem.swp.POSTResponds;

import com.rentalsystem.swp.Repositories.UserRepository;
import com.rentalsystem.swp.dao.UserProfile;
import lombok.Data;

import java.util.Optional;

@Data
public class UserProfileData {

    long id;
    String firstName;
    String lastName;
    String email;
    String password;
    String phoneNumber;

}
