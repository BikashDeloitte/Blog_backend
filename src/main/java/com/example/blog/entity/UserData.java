package com.example.blog.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserData {
    @Id
    @GeneratedValue
    private Long id;
    @Size(min = 3, message = "first name should be atleast 3 character")
    private String firstName;
    private String middleName;
    @Size(min = 3, message = "first name should be atleast 3 character")
    private String lastName;

    @Column(unique = true)
    @Email(message = "please enter valid email", regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    @NotBlank(message = "please mention your email")
    private String email;

    //    @JsonIgnore
    @NotBlank(message = "please enter your password")
    private String password;
    private String about;
}
