package com.chatapp.model;

import com.chatapp.annotation.FieldsValueMatch;
import com.chatapp.annotation.PassWorldValidator;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;


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
    @GenericGenerator(name = "native",strategy = "native")
    private int geekId;

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

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,targetEntity = Message.class)
    @JoinColumn(name = "Message_FK",referencedColumnName = "messageId",nullable = true)
    private List<Message> messages;


}
