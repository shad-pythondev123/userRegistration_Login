package com.example.userRegistration_Authentication.Repository;

import com.example.userRegistration_Authentication.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
