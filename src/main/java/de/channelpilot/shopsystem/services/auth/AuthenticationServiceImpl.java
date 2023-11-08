package de.channelpilot.shopsystem.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import de.channelpilot.shopsystem.dtos.SignUpRequest;
import de.channelpilot.shopsystem.dtos.SigninRequest;
import de.channelpilot.shopsystem.model.Role;
import de.channelpilot.shopsystem.model.User;
import de.channelpilot.shopsystem.repositories.UserRepository;
import de.channelpilot.shopsystem.services.jwt.JwtAuthenticationResponse;
import de.channelpilot.shopsystem.services.jwt.JwtService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	@Autowired
    private UserRepository userRepository;
	@Autowired
    private PasswordEncoder passwordEncoder;
	@Autowired
    private JwtService jwtService;
	@Autowired
    private AuthenticationManager authenticationManager;
	
    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        User user = new User(request.getFirstName(), request.getLastName(), request.getEmail(), passwordEncoder.encode(request.getPassword()), Role.USER);
        userRepository.save(user);
        String jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }

    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        String jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }
}