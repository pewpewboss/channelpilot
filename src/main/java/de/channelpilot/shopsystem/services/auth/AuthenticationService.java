package de.channelpilot.shopsystem.services.auth;

import de.channelpilot.shopsystem.dtos.SignUpRequest;
import de.channelpilot.shopsystem.dtos.SigninRequest;
import de.channelpilot.shopsystem.services.jwt.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}