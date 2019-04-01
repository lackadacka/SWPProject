package com.rentalsystem.swp.models;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
public class UserProfile {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    private String phoneNumber;
    @Enumerated(value = EnumType.STRING)
    private Role role;





}