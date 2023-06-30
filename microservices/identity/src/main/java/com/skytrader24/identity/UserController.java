package com.skytrader24.identity;


import com.skytrader24.identity.dto.InfoAboutCreatedUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping("/register")
    ResponseEntity<InfoAboutCreatedUserDto> registerNewUser(@RequestBody RegisterNewUserDTO request) {
        InfoAboutCreatedUserDto infoAboutCreatedUserDto = userService.registerNewUser(request);

        return null;
    }


}
