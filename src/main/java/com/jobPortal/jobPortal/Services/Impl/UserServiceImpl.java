package com.jobPortal.jobPortal.Services.Impl;

import com.jobPortal.jobPortal.Model.User;
import com.jobPortal.jobPortal.Model.UserProfile;
import com.jobPortal.jobPortal.Repository.UserRepository;
import com.jobPortal.jobPortal.Services.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserProfile getUserProfile(String email) {
        User u = userRepository.findById(email).orElse(null);
        if (u == null || u.getUserProfile() == null) {
            return null;
        }
        return u.getUserProfile();
    }

    @Override
    public boolean isValid(User user) {
        return userRepository.findById(user.getEmail()).orElse(null) != null;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }
}
