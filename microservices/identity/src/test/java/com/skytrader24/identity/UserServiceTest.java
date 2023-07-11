package com.skytrader24.identity;

import com.skytrader24.identity.dto.CreatedUserDto;
import com.skytrader24.identity.dto.RegisterNewUserDTO;
import com.skytrader24.identity.entity.UserEntity;
import com.skytrader24.identity.repository.UserRepository;
import com.skytrader24.identity.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;

    private final String VALID_EMAIL = "Jan.Kowalski@example.com";
    private final String VALID_USERNAME = "Testovirus123";
    private final String VALID_PASSWORD = "pass123456%";
    private final Long VALID_ID = 1L;


    @Test
    void shouldRegisterNewUserWhenValidRegisterNewUserDTO(){
        // Given
        var request = new RegisterNewUserDTO(VALID_EMAIL, VALID_USERNAME, VALID_PASSWORD);

        given(userRepository.createUser(request.email(), request.username(), request.password()))
                                        .willReturn(Optional.of(UserEntity.builder()
                                        .id(VALID_ID)
                                        .username(request.username())
                                        .build()));

        // When
        CreatedUserDto response = userService.registerNewUser(request);

        // Then
        assertAll("Response fields should be valid and userRepository should be invoked",
                () -> assertThat(response.id()).isEqualTo(VALID_ID),
                () -> assertThat(response.username()).isEqualTo(request.username()),
                () -> verify(userRepository, times(1)).createUser(request.email(),
                                                                                         request.username(),
                                                                                         request.password())
        );
    }

/*    @Test
    void shouldNotRegisterNewUserWhenUsernameExistInRepository() {
    }

    @Test
    void shouldNotRegisterNewUserWhenSameEmailExistInRepository() {
    }

    @Test
    void shouldThrowUserRegistrationExceptionWhenIsProblem() {
    }*/




}