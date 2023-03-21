package rva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import rva.model.Banka;
import rva.service.BankaService;

@RestController
public class BankaController {

		@Autowired
		private BankaService service;
		
		@GetMapping("/hello")
		public String sayHello() {
			return "Hello there!";
		}
		
		@GetMapping ("/banka")
		public ResponseEntity <List<Banka>> findAllBanks(){	
			return ResponseEntity.ok(service.findAll());
		}
		
		@GetMapping("/banka{id}")
		public ResponseEntity<?> getBankaById(@PathVariable long id){
			if(service.existsById(id)) {
				return ResponseEntity.ok(service.findById(id));
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("Resource with requested ID:" + id + "does not exist");
			}
		}
		
		@GetMapping("/banka/naziv/{naziv}")
		public ResponseEntity<?> getBankaByNaziv(@PathVariable String naziv){
			if(service.findByNaziv(naziv).get().isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("Resource with requested Naziv: " + naziv + "does not exist");
			}else {
				return ResponseEntity.ok(service.findByNaziv(naziv).get());
				//return ResponseEntity.status(Http)
			}
		}
		
}
