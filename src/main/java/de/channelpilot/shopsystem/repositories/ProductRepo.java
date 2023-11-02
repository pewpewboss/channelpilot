package de.channelpilot.shopsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.channelpilot.shopsystem.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
