package com.salesianostriana.dam.jwt.security.user.controller;

import com.salesianostriana.dam.jwt.security.security.jwt.access.JwtService;
import com.salesianostriana.dam.jwt.security.security.jwt.refresh.RefreshToken;
import com.salesianostriana.dam.jwt.security.security.jwt.refresh.RefreshTokenRequest;
import com.salesianostriana.dam.jwt.security.security.jwt.refresh.RefreshTokenService;
import com.salesianostriana.dam.jwt.security.security.jwt.verification.VerificationToken;
import com.salesianostriana.dam.jwt.security.security.jwt.verification.VerificationTokenException;
import com.salesianostriana.dam.jwt.security.security.jwt.verification.VerificationTokenService;
import com.salesianostriana.dam.jwt.security.user.dto.CreateUserRequest;
import com.salesianostriana.dam.jwt.security.user.dto.LoginRequest;
import com.salesianostriana.dam.jwt.security.user.dto.UserResponse;
import com.salesianostriana.dam.jwt.security.user.model.User;
import com.salesianostriana.dam.jwt.security.user.service.EmailService;
import com.salesianostriana.dam.jwt.security.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;
    private final VerificationTokenService verificationTokenService;
    private final EmailService emailService;


    // VERIFICACIÓN POR CORREO ELECTRÓNICO ---------------------------------------------------------------------------------------

    @PostMapping("/auth/register")
    public ResponseEntity<UserResponse> register(@RequestBody CreateUserRequest createUserRequest) {
        User user = userService.createUser(createUserRequest);
        VerificationToken token = verificationTokenService.create(user);

        emailService.sendVerificationEmail(user, token);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserResponse.of(user));
    }

    @GetMapping("/auth/verify")
    public ResponseEntity<String> verifyAccount(@RequestParam String token) {
        Optional<VerificationToken> verificationToken = verificationTokenService.findByToken(token);

        verificationTokenService.verifyToken(verificationToken.get());

        return ResponseEntity.ok("Cuenta verificada con éxito!");
    }

    // ---------------------------------------------------------------------------------------------------------------------------

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {


        Authentication authentication =
                authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.username(),
                        loginRequest.password()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = (User) authentication.getPrincipal();

        String accessToken = jwtService.generateAccessToken(user);

        // Generar el token de refresco
        RefreshToken refreshToken = refreshTokenService.create(user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserResponse.of(user, accessToken, refreshToken.getToken()));

    }

    @PostMapping("/auth/refresh/token")
    public ResponseEntity<?> refreshToken(@RequestBody RefreshTokenRequest req) {
        String token = req.refreshToken();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(refreshTokenService.refreshToken(token));

    }







    @GetMapping("/me")
    public UserResponse me(@AuthenticationPrincipal User user) {
        return UserResponse.of(user);
    }

    @GetMapping("/me/admin")
    public User adminMe(@AuthenticationPrincipal User user) {
        return user;
    }

}



