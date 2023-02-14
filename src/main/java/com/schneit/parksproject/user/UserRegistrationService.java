package com.schneit.parksproject.user;

import com.schneit.parksproject.exception.GenericException;
import com.schneit.parksproject.utils.StringHashingService;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService implements IUserRegistrationService {

    private UserRepository userRepository;
    private StringHashingService stringHashingService;
    @Override
    public UserModel registerUser(String userName, String name, String password) throws Exception {
//        check if user exists
        if (userRepository.getUserByUserName(userName) != null) {
            throw new Exception("User already exists");
        }
        UserModel user = new UserModel();
        user.setUserName(userName);
        user.setName(name);
        String hashedPassword = stringHashingService.hashString(password);
        user.setPassword(hashedPassword);

        userRepository.registerNewUser(user);

        return user;
    }
}
