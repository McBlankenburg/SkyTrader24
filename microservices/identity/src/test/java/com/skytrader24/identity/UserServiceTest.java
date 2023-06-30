package com.skytrader24.identity;

import com.skytrader24.identity.dto.InfoAboutCreatedUserDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UserServiceTest {

    @Test
    void shouldRegisterNewUser(){
        // Given
        UserService userService = new UserService();
        RegisterNewUserDTO request = new RegisterNewUserDTO("JohnSmith123", "pass123", "john.Smith@example.com");

        // When
        InfoAboutCreatedUserDto newUser = userService.registerNewUser(request);

        // Then
        assertThat(
                request.username()).as("Username should match").isEqualTo(newUser.username());

        assertThat(
                request.email()).as("Email should match").isEqualTo(newUser.email());

        assertThat(
                newUser.id()).as("User ID should not be null").isNotNull();
    }

    @Test
    void shouldNotRegisterNewUserWhenUsernameExistInRepository() {
        //TODO
    }

    @Test
    void shouldNotRegisterNewUserWhenSameEmailExistInRepository() {
        //TODO
    }




}