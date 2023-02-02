package com.schneit.parksproject.authentication;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.ArrayList;

// https://www.baeldung.com/spring-security-authentication-provider
public class EmailPasswordAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

            String name = authentication.getName();
            String password = authentication.getCredentials().toString();

            // use the credentials
            // and authenticate against the third-party system
            // authenticate against DB not 3P
            return new UsernamePasswordAuthenticationToken(
                    name, password, new ArrayList<>());

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
