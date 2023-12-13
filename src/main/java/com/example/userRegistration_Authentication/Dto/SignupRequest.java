package com.example.userRegistration_Authentication.Dto;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SignupRequest {
    String name;
    @Column(unique = true)
    String email;
    String password;
    String phone;
}
