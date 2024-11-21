package com.jobPortal.jobPortal.Repository;

import com.jobPortal.jobPortal.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
