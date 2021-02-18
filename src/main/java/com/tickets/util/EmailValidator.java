package com.tickets.util;

import com.tickets.annotation.EmailValidation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailValidation, String> {
    private static final String REGEX = "[/A[^@]+@([^@\\.]+\\.)+[^@\\.]+z/]";

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return email != null && email.matches(REGEX);
    }
}
