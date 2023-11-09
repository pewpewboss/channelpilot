package de.channelpilot.shopsystem.services.product;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.channelpilot.shopsystem.dtos.IProduct;
import de.channelpilot.shopsystem.model.Product;
import de.channelpilot.shopsystem.repositories.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	@Autowired
    private ModelMapper modelMapper;

	public Product getProductById(Long id) throws Exception {
		Optional<Product> findById = productRepo.findById(id);
		if(!findById.isPresent()) {
			throw new Exception("No existing Product found for id: " + id);
		}
		return findById.get();
	}

	public void saveOrUpdateProduct(IProduct p) {
		Product product = modelMapper.map(p, Product.class);
		Product save = productRepo.save(product);
	}
}
