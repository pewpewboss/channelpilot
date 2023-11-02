package de.channelpilot.shopsystem.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

	@PostMapping(value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String postProduct(@RequestBody String json) {
		return "Thank you for providing us with " + json;
	}
}
