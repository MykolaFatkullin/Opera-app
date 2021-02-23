package com.tickets.util;

import com.tickets.annotation.EmailValidation;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailValidation, String> {
    private static final String REGEX = "^\\S+@\\S+\\.\\S+$";

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return email != null && email.matches(REGEX);
    }
}
