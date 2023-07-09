package com.skytrader24.identity;

import com.skytrader24.identity.dto.CreatedUserDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public CreatedUserDto registerNewUser(RegisterNewUserDTO request) {
        return userRepository.createUser(request.email(), request.username(), request.password())
                .map(userEntity -> new CreatedUserDto(userEntity.getId(), userEntity.getUsername()))
                .orElseThrow(() -> new UserRegistrationException("User has not been created"));
    }
}
