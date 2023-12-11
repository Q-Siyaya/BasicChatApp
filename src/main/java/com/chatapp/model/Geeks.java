package com.chatapp.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Geeks
{
    @NotBlank(message = "Cannot leave first name empty")
    @Pattern(regexp = "[a-zA-Z]",message = "Name can be only be alphabetic characters")
    private String firstName;


    @NotBlank(message = "Cannot leave Last name empty")
    @Pattern(regexp = "[a-zA-Z]",message = "Name can be only be alphabetic characters")
    private String lastName;

    private String chatStatus;

    @Email(message = "Please enter valid email")
    private String email;


    private String password;

    private String passwordConfirm;
}
