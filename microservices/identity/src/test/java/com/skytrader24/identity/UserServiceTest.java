package com.skytrader24.identity;

import com.skytrader24.identity.dto.CreatedUserDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.BDDMockito.given;

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
                                        .willReturn(Optional.of(new UserEntity.UserEntityBuilder()
                                        .id(VALID_ID)
                                        .username(request.username())
                                        .build()));

        // When
        CreatedUserDto response = userService.registerNewUser(request);

        // Then
        assertAll("Response fields should be valid",
                () -> assertThat(response).isNotNull(),
                () -> assertThat(response.id()).isEqualTo(VALID_ID),
                () -> assertThat(response.username()).isEqualTo(request.username())
        );
    }

    @Test
    void shouldNotRegisterNewUserWhenUsernameExistInRepository() {



    }

    @Test
    void shouldNotRegisterNewUserWhenSameEmailExistInRepository() {
        //TODO
    }

    @Test
    void shouldThrowUserRegistrationExceptionWhenIsProblem() {
        //TODO
    }




}