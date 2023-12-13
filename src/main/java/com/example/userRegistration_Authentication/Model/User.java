package com.example.userRegistration_Authentication.Model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.checkerframework.common.aliasing.qual.Unique;
import org.springframework.data.annotation.AccessType;

import java.util.logging.Level;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @Column(unique = true)
    String email;
    String password;
    String phone;

}
