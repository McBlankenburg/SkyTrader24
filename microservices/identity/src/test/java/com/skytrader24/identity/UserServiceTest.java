package com.skytrader24.identity;

import com.skytrader24.identity.dto.CreatedUserDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

class UserServiceTest {

    @Test
    void shouldRegisterNewUserWhenValidRegisterNewUserDTO(){
        // Given
        var userRepository = Mockito.mock(UserRepository.class);
        var userService = new UserService(userRepository);
        long randomId = 10;
        String randomUsername = "testovirus";
        var request = new RegisterNewUserDTO(randomUsername, "pass123", "john.Smith@example.com");
        given(userRepository.createUser(Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
                                        .willReturn(Optional.of(new UserEntity.UserEntityBuilder()
                                        .id(randomId)
                                        .username(request.username())
                                        .build()));
        // When
        CreatedUserDto response = userService.registerNewUser(request);

        // Then
        assertThat(response).isNotNull();
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