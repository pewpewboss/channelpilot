package de.channelpilot.shopsystem.controller;

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
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class EndpointController {

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
		return ResponseEntity.ok("Thank you for supplying using V1 & supplying us with the product information");
	}

	@PostMapping(value = "v2/product")
	@ResponseBody
	public ResponseEntity<String> postProduct(@Valid @RequestBody ProductDTOV2 p, Errors errors) {
		if(errors.hasErrors()) return ResponseEntity.badRequest().body("Mandatory fields have not been sent");
		return ResponseEntity.ok("Thank you for using V2 & supplying us with the product information");
	}
}
