package com.skytrader24.identitymanagement.login;

import com.skytrader24.identitymanagement.UserRepository;
import com.skytrader24.identitymanagement.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String generateToken(CredentialsDTO loginRequest) {
        String username = loginRequest.username();
        String password = loginRequest.password();

        boolean isValidUser = userRepository.findByUsernameAndPassword(username, password)
                .filter(UserEntity::isActive)
                .isPresent();


        if(isValidUser){
            //TODO: generateJwtToken
            return "MOCK TOKEN JWT";
        }
        return "NOT IMPLEMENTED YET, GLOBALHANDLER";
    }
}
