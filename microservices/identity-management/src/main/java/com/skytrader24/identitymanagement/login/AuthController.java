package com.skytrader24.identitymanagement.login;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/token")
    public ResponseEntity<String> generateToken(@RequestBody CredentialsDTO loginRequest) {
        String jwtToken = authService.generateToken(loginRequest);
        return ResponseEntity.ok(jwtToken);
    }

}
