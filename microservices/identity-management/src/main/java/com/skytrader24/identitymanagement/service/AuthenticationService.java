package com.skytrader24.identitymanagement.service;

import com.skytrader24.identitymanagement.model.CredentialsDTO;
import com.skytrader24.identitymanagement.repository.UserRepository;
import com.skytrader24.identitymanagement.model.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String generateToken(CredentialsDTO loginRequest) {
        String email = loginRequest.email();
        String password = loginRequest.password();

        boolean isValidUser = userRepository.findByEmailAndPassword(email, password)
                .filter(UserEntity::isActive)
                .isPresent();


        if(isValidUser){
            //TODO: generateJwtToken
            return "MOCK TOKEN JWT";
        }
        return "NOT IMPLEMENTED YET, GLOBALHANDLER";
    }
}