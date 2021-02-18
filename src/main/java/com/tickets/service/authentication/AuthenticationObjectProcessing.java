package com.tickets.service.authentication;

import org.springframework.security.core.Authentication;

public interface AuthenticationObjectProcessing {
    String getUsername(Authentication authentication);
}
