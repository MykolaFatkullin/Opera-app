package com.tickets.service.authentication.impl;

import com.tickets.service.authentication.AuthenticationObjectProcessing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationObjectProcessingImpl implements AuthenticationObjectProcessing {
    @Override
    public String getUsername(Authentication authentication) {
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        return principal.getUsername();
    }
}
