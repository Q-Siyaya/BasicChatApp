package com.chatapp.model;

import lombok.*;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Geeks
{
    private String firstName;

    private String lastName;

    private String chatStatus;


    private String email;


    private String password;

    private String passwordConfirm;
}
