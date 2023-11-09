package de.channelpilot.shopsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.channelpilot.shopsystem.dtos.SignUpRequest;
import de.channelpilot.shopsystem.dtos.SigninRequest;
import de.channelpilot.shopsystem.services.auth.AuthenticationService;
import de.channelpilot.shopsystem.services.jwt.JwtAuthenticationResponse;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/signup")
	public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
		return ResponseEntity.ok(authenticationService.signup(request));
	}

	@PostMapping("/signin")
	public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {
		return ResponseEntity.ok(authenticationService.signin(request));
	}
}