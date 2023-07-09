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

    @Test
    void shouldRegisterNewUserWhenValidRegisterNewUserDTO(){
        // Given
        String email = "john.Smith@example.com";
        String username = "testovirus";
        String password = "pass123456";

        var request = new RegisterNewUserDTO(email, username, password);

        given(userRepository.createUser(email, username, password))
                                        .willReturn(Optional.of(new UserEntity.UserEntityBuilder()
                                        .id(1L) //random value
                                        .username(request.username())
                                        .build()));

        // When
        CreatedUserDto response = userService.registerNewUser(request);

        // Then
        assertAll("Response fields should be valid",
                () -> assertThat(response).isNotNull(),
                () -> assertThat(response.id()).isEqualTo(1L),
                () -> assertThat(response.username()).isEqualTo(username)
        );
    }

    @Test
    void shouldNotRegisterNewUserWhenUsernameExistInRepository() {
        //TODO
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