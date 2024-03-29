package com.schneit.parksproject.utils;

import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StringHashingService implements IStringHashingService{

    @Override
    public String hashString(String string) {
        Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder();
        String hashedString = encoder.encode(string);
        return hashedString;
    }

    // Add matching class
    public Boolean matchingString(String hashed, String unhashed) {
        boolean isMatching = hashed.equals(hashString(unhashed));
        return  isMatching;
    }
}
