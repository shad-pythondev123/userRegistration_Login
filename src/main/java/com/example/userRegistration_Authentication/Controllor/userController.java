package com.example.userRegistration_Authentication.Controllor;

import com.example.userRegistration_Authentication.Dto.SignupRequest;
import com.example.userRegistration_Authentication.Dto.UserDto;
import com.example.userRegistration_Authentication.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
public class userController {
    @Autowired
    private AuthService authService;
    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody SignupRequest signUpRequest){
        String s=authService.createUser(signUpRequest);

        return new ResponseEntity<>(s,HttpStatus.OK);
    }
    @PostMapping("/validate")
    public ResponseEntity<?>validateOtp(@RequestParam String generatedOtp){
        try{
           UserDto dto= authService.ValidateOtp(generatedOtp);
           return new ResponseEntity<>(dto,HttpStatus.CREATED);

        }catch(RuntimeException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getUser")
    public ResponseEntity<?> getUserByEmail( @RequestParam String email){
        try{
            UserDto dto=authService.getUserByEmail(email);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }catch(RuntimeException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
