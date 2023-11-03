package de.channelpilot.shopsystem.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.channelpilot.shopsystem.dtos.ProductDTO;
import de.channelpilot.shopsystem.dtos.ProductDTOV2;
import de.channelpilot.shopsystem.model.Product;
import de.channelpilot.shopsystem.services.ProductService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class EndpointController {

	@Autowired
	private ProductService prodService;
	@Autowired
    private ModelMapper modelMapper;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ResponseEntity<String> index() {
		return ResponseEntity.ok("Index");
	}

	@GetMapping(value = "food/{id}")
	@ResponseBody
	public String getFood(@PathVariable Integer id) {
		return "food: " + id;
	}

	@PostMapping(value = "v1/product")
	@ResponseBody
	public ResponseEntity<String> postProduct(@Valid @RequestBody ProductDTO p, Errors errors) {
		if(errors.hasErrors()) return ResponseEntity.badRequest().body("Mandatory fields have not been sent");
		Product product = modelMapper.map(p, Product.class);
		prodService.saveOrUpdateProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body("Thank you for supplying using V1 & supplying us with the product information");
	}

	@PostMapping(value = "v2/product")
	@ResponseBody
	public ResponseEntity<String> postProduct(@Valid @RequestBody ProductDTOV2 p, Errors errors) {
		if(errors.hasErrors()) return ResponseEntity.badRequest().body("Mandatory fields have not been sent");
		Product product = modelMapper.map(p, Product.class);
		prodService.saveOrUpdateProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body("Thank you for supplying using V1 & supplying us with the product information");
	}
}
