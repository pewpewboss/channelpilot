package de.channelpilot.shopsystem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.channelpilot.shopsystem.model.Product;
import de.channelpilot.shopsystem.repositories.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;

	public Product getProductById(Long id) throws Exception {
		Optional<Product> findById = productRepo.findById(id);
		if(!findById.isPresent()) {
			throw new Exception("No existing Product found for id: " + id);
		}
		return findById.get();
	}

	public void saveOrUpdateProduct(Product p) {
		Product save = productRepo.save(p);
	}
}
