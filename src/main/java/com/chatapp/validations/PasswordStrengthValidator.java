package com.chatapp.validations;

import com.chatapp.annotation.PassWorldValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class PasswordStrengthValidator implements ConstraintValidator<PassWorldValidator,String>
{
    private String regexPattern;
    @Override
    public void initialize(PassWorldValidator constraintAnnotation) {
        regexPattern = "^(?=(.*[a-z]){2})(?=(.*[A-Z]){2})(?=(.*\\d){2})(?=(.*[!@#$%^&*()-_+=<>?/{}|~]){2})[^\\s]{8,}$";
    }


    @Override
    public boolean isValid(String passwordFeild, ConstraintValidatorContext constraintValidatorContext) {


        return passwordFeild.trim().matches(regexPattern);
    }
}
