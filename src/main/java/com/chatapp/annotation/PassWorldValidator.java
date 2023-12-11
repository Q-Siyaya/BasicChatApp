package com.chatapp.annotation;

import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PassWorldValidator {
    String message() default "Please choose a strong password";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
