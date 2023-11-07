package de.channelpilot.shopsystem.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import de.channelpilot.shopsystem.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);
}
