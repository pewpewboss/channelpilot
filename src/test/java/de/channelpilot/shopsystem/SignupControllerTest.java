package de.channelpilot.shopsystem;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.channelpilot.shopsystem.dtos.SignUpRequest;
import de.channelpilot.shopsystem.dtos.SigninRequest;
import de.channelpilot.shopsystem.model.Role;
import de.channelpilot.shopsystem.model.User;
import de.channelpilot.shopsystem.repositories.UserRepository;
import de.channelpilot.shopsystem.services.jwt.JwtAuthenticationResponse;
import de.channelpilot.shopsystem.services.jwt.JwtService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SignupControllerTest {
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    private SignUpRequest signUp;
    private SigninRequest signIn;
    private User user;

    @BeforeEach
    public void setUp() {
        signUp = new SignUpRequest();
        signUp.setFirstName("hans");
        signUp.setLastName("peter");
        String email = "hp@gmail.de";
		signUp.setEmail(email);
		String password = "testpassword";
        signUp.setPassword(password);
        
        signIn = new SigninRequest();
        signIn.setEmail(email);
		signIn.setPassword(password);

        user = new User(signUp.getFirstName(), signUp.getLastName(), signUp.getEmail(), passwordEncoder.encode(signUp.getPassword()), Role.USER);
        when(userRepository.save(user)).thenReturn(user);
    }

    @Test
    public void testSignup() throws Exception {

        // Send a POST request to /signup with the SignUpRequest object as the request body
        MvcResult result = mockMvc.perform(post("/api/v1/auth/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(signUp)))
                .andExpect(status().isOk())
                .andReturn();

        // Verify that the response contains a JWT
        String responseJson = result.getResponse().getContentAsString();
        JwtAuthenticationResponse response = new ObjectMapper().readValue(responseJson, JwtAuthenticationResponse.class);
        assertNotNull(response.getJwt());
    }
    
    @Test
    public void testSignin() throws Exception {

        // Send a POST request to /signin with the SignInRequest object as the request body
        MvcResult result = mockMvc.perform(post("/api/v1/auth/signin")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(signIn)))
                .andExpect(status().isOk())
                .andReturn();

        // Verify that the response contains a JWT
        String responseJson = result.getResponse().getContentAsString();
        JwtAuthenticationResponse response = new ObjectMapper().readValue(responseJson, JwtAuthenticationResponse.class);
        assertNotNull(response.getJwt());
    }
}