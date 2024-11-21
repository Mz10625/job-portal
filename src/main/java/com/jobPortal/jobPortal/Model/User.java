package com.jobPortal.jobPortal.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    private String email;
    private String username;
    private String password;
    @OneToMany
    List<Job> applications;
    @OneToOne
    UserProfile userProfile;
}
