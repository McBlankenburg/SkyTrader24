package com.skytrader24.identity.controller;


import com.skytrader24.identity.dto.RegisterNewUserDTO;
import com.skytrader24.identity.service.UserService;
import com.skytrader24.identity.dto.CreatedUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<CreatedUserDto> registerNewUser(@RequestBody RegisterNewUserDTO request) {
        CreatedUserDto createdUserDto = userService.registerNewUser(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(createdUserDto);

    }


}
