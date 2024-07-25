package com.bank.Controlers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Аутентификация")
public class AuthController {

//    @Operation(summary = "Авторизация пользователя")
//    @PostMapping("/sign-in")
//    public JwtAuthenticationResponse signIn(@RequestBody @Valid SignInRequest request) {
//        return authenticationService.signIn(request);
//    }
}
