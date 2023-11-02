package de.channelpilot.shopsystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EndpointController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ResponseEntity<String> index(){
		return ResponseEntity.ok("Index");
	}
	
	@GetMapping(value = "/food/{id}")
	@ResponseBody
	public String getFood(@PathVariable Integer id){
		return "food: " + id;
	}

}
