package com.chatapp.model;

import com.chatapp.annotation.FieldsValueMatch;
import com.chatapp.annotation.PassWorldValidator;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Geek")
@FieldsValueMatch(
        field = "password",
        fieldMatch = "passwordConfirm",
        message = "Password do not match"
)
public class Geeks extends BaseEntity
{

    @NotBlank(message = "Cannot leave first name empty")
    @Pattern(regexp = "[a-zA-Z]",message = "Name can be only be alphabetic characters")
    private String firstName;


    @NotBlank(message = "Cannot leave Last name empty")
    @Pattern(regexp = "[a-zA-Z]",message = "Name can be only be alphabetic characters")
    private String lastName;


    private String chatStatus;

    @Email(message = "Please enter valid email")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    @NotBlank(message = "Please confirm your password")
    @PassWorldValidator(message = "Password should 8 min chan consist of atleat 2, numbers, uppercase letter" +
            ", lowercase letter and special characters")
    private String passwordConfirm;


}
