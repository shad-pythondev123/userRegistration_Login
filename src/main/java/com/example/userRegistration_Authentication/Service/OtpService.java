package com.example.userRegistration_Authentication.Service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OtpService {
    public static final int otpLength=6;
    public String generateOtp(){
        Random random= new Random();
        StringBuilder otp= new StringBuilder();
        for(int i=0; i<otpLength; i++){
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }
}
