package de.channelpilot.shopsystem.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.channelpilot.shopsystem.config.MessageConfig;
import de.channelpilot.shopsystem.dtos.ProductDTO;
import de.channelpilot.shopsystem.dtos.ProductDTOV2;
import de.channelpilot.shopsystem.services.product.ProductService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class EndpointController {

	@Autowired
	private ProductService prodService;
	@Autowired
	RabbitTemplate rabbitTemplate;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ResponseEntity<String> index() {
		return ResponseEntity.ok("Index");
	}

	/**
	 * V1 Enables us to recieve Data from a Client
	 * @param p The ProductDTO defines a contract for the body if client if he wants to use this service. 
	 * @param errors occur e.g. when body validation failed
	 * @return Response OK or bad request
	 */
	@PostMapping(value = "v1/product")
	@ResponseBody
	public ResponseEntity<String> postProduct(@Valid @RequestBody ProductDTO p, Errors errors) {
		if(errors.hasErrors()) return ResponseEntity.badRequest().body("Mandatory fields have not been sent");
		prodService.saveOrUpdateProduct(p);
	    rabbitTemplate.convertAndSend(MessageConfig.TOPIC, "v1.product.saved", "Entity got saved");
		return ResponseEntity.status(HttpStatus.CREATED).body("Thank you for supplying using V1 & supplying us with the product information");
	}

	@PostMapping(value = "v2/product")
	@ResponseBody
	public ResponseEntity<String> postProduct(@Valid @RequestBody ProductDTOV2 p, Errors errors) {
		if(errors.hasErrors()) return ResponseEntity.badRequest().body("Mandatory fields have not been sent");
		prodService.saveOrUpdateProduct(p);
		rabbitTemplate.convertAndSend(MessageConfig.TOPIC, "v2.product.saved", "Entity got saved");
		return ResponseEntity.status(HttpStatus.CREATED).body("Thank you for supplying using V1 & supplying us with the product information");
	}
}
