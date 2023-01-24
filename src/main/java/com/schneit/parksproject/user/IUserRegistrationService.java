package com.schneit.parksproject.user;

import com.schneit.parksproject.exception.GenericException;

public interface IUserRegistrationService {
    public UserModel registerUser (String userName, String name, String password) throws Exception;

}
