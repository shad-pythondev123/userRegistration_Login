package com.example.userRegistration_Authentication.Dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationRequest {
    String email;
    String password;
}
