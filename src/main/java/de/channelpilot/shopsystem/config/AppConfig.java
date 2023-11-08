package de.channelpilot.shopsystem.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.channelpilot.shopsystem.services.jwt.JwtService;
import de.channelpilot.shopsystem.services.jwt.JwtServiceImpl;
import de.channelpilot.shopsystem.services.user.UserService;
import de.channelpilot.shopsystem.services.user.UserServiceImpl;

@Configuration
public class AppConfig {
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}
