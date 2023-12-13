package com.chatapp.model;

import com.chatapp.annotation.FieldsValueMatch;
import com.chatapp.annotation.PassWorldValidator;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;


@Getter
@Setter
@Entity
@Table(name = "Geek")
@FieldsValueMatch(
        field = "password",
        fieldMatch = "passwordConfirm",
        message = "Password do not match"
)
public class Geek extends BaseEntity
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native")
    private int geekId;

    @NotBlank(message = "Cannot leave first name empty")
    private String firstName;


    @NotBlank(message = "Cannot leave Last name empty")
    private String lastName;


    private String chatStatus;

    @Email(message = "Please enter valid email")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @PassWorldValidator
    private String password;


    @NotBlank(message = "Please confirm your password")
    @Transient
    private String passwordConfirm;


}
