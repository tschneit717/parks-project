package com.schneit.parksproject.authentication;

import com.schneit.parksproject.user.UserModel;
import com.schneit.parksproject.user.UserRepository;
import com.schneit.parksproject.utils.StringHashingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


// https://www.baeldung.com/spring-security-authentication-provider
@Component
public class EmailPasswordAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    StringHashingService stringHashingService;

    @Autowired
    UserRepository userRepository;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        // use the credentials
        // and authenticate against the third-party system
        // authenticate against DB not 3P
        try {
            UserModel user = userRepository.getUserByUserName(name);
            // check if password is correct
            String hashedPassword = user.getPassword();
            boolean correctPassword = stringHashingService.matchingString(hashedPassword, password);
            if (correctPassword) {
                return new UsernamePasswordAuthenticationToken(
                        name, password, new ArrayList<>());
            }
            throw new Exception();
        } catch (Exception error) {
            throw new CustomAuthenticationException("Incorrect Username or Password");
        }


    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
