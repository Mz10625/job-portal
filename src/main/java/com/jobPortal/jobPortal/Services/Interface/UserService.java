package com.jobPortal.jobPortal.Services.Interface;

import com.jobPortal.jobPortal.Model.User;
import com.jobPortal.jobPortal.Model.UserProfile;

public interface UserService {
    public UserProfile getUserProfile(String email);
    public boolean isValid(User user);
    public void addUser(User user);
}
