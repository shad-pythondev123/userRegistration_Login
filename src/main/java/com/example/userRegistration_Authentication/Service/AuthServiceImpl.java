package com.example.userRegistration_Authentication.Service;

import com.example.userRegistration_Authentication.Dto.SignupRequest;
import com.example.userRegistration_Authentication.Dto.UserDto;
import com.example.userRegistration_Authentication.Model.User;
import com.example.userRegistration_Authentication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OtpService otpService;
    @Autowired
    JavaMailSender javaMailSender;

    User user= new User();
 String otp= "";
    @Override
    public String createUser(SignupRequest signUpRequest) {
        user.setName(signUpRequest.getName());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signUpRequest.getPassword()));
        user.setPhone(signUpRequest.getPhone());
        otp=otpService.generateOtp();
         User user1= user;
//         user1=user;
        SimpleMailMessage message= new SimpleMailMessage();
                message.setTo(user1.getEmail());
                message.setSubject("your OTP is");
                message.setText("Your OTP is "+ otp+" .Kindly verify your otp!");
                javaMailSender.send(message);

//        i have to generate and send the otp on mail, after generating otp store in the otp attr. then send
//


//
        return "OTP sent! kindly verify.";
    }

    @Override
    public UserDto ValidateOtp(String generatedOtp) throws RuntimeException{
        if(generatedOtp.equals(otp)){
           userRepository.save(user);
            User savedUser= userRepository.save(user);
        UserDto userDto= new UserDto();
        userDto.setName(savedUser.getName());
        userDto.setEmail(savedUser.getEmail());
        userDto.setPhone(savedUser.getPhone());
            otp="";
        return userDto;

        }else{
          throw new RuntimeException("OTP invalid");
        }

    }

    @Override
    public UserDto getUserByEmail(String email) throws RuntimeException {
        Optional<User> user= Optional.ofNullable(userRepository.findByEmail(email));
        if(user.isPresent()){
            UserDto dto= new UserDto();
            dto.setName(user.get().getName());
            dto.setEmail(user.get().getEmail());
            dto.setPhone(user.get().getPhone());
            return dto;
        }
        throw new RuntimeException("User not found!");
    }
}
