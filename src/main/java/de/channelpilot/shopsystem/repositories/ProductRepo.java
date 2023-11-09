package de.channelpilot.shopsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.channelpilot.shopsystem.model.Product;
//TODO maybe change this to IProduct later on
public interface ProductRepo extends JpaRepository<Product, Long> {

}
