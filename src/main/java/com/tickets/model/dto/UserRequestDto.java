package com.tickets.model.dto;

import com.tickets.annotation.EmailValidation;
import com.tickets.annotation.FieldsValueMatch;

@FieldsValueMatch.List({
        @FieldsValueMatch(
                field = "password",
                fieldMatch = "repeatPassword",
                message = "Passwords do not match!"
        )})
public class UserRequestDto {
    @EmailValidation(message = "Incorrect email")
    private String email;
    private String password;
    private String repeatPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
