package com.example.userRegistration_Authentication.Service;

import com.example.userRegistration_Authentication.Dto.SignupRequest;
import com.example.userRegistration_Authentication.Dto.UserDto;
import com.example.userRegistration_Authentication.Model.User;

public interface AuthService {
    String createUser(SignupRequest signUpRequest);
    UserDto ValidateOtp(String generatedOtp) throws RuntimeException;

    UserDto getUserByEmail(String email);
}
