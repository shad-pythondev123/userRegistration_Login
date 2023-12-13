package com.example.userRegistration_Authentication.Dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationResponse {
    String jwt;
}
