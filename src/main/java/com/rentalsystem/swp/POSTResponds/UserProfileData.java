package com.rentalsystem.swp.POSTResponds;

import com.rentalsystem.swp.models.Role;
import com.rentalsystem.swp.models.UserProfile;
import lombok.Data;

@Data
public class UserProfileData {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private Role role;
    public UserProfileData(UserProfile userProfile) {
        id = userProfile.getId();
        email = userProfile.getEmail();
        firstName = userProfile.getFirstName();
        lastName = userProfile.getLastName();
        role = userProfile.getRole();
    }
}
