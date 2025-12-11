package rva.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rva.model.Banka;
import rva.service.BankaService;


@CrossOrigin
@RestController
public class BankaController {

		@Autowired
		private BankaService service;
		
		@GetMapping ("/banka")
		public ResponseEntity <List<Banka>> findAllBanks(){	
			return ResponseEntity.ok(service.findAll());
		}
		
		@GetMapping("/banka/{id}")
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
			}
		}
		
		@GetMapping("/banka/bankaSearch/{search}")
		public  ResponseEntity<?> getBankaBySearch(@PathVariable String search){
			
			List<Banka> bolnice = service.findBySearch(search);
			if(bolnice.isEmpty())
				return new ResponseEntity<>(
				          "Ni jedna slicna banka ne postoji", 
				          HttpStatus.NOT_FOUND);
			return ResponseEntity.status(HttpStatus.OK)
			        .body(bolnice);
		}
		
		//*********************************
		//			DODAJ BANKU			  *
		//*********************************
		
		@PostMapping("/banka")
		public ResponseEntity<?> createBanka(@RequestBody Banka banka){
			Banka savedBanka;
			if(!service.existsById(banka.getId())) {
				
				savedBanka = service.save(banka);
				
			} else {
				
				List<Banka> lista = service.findAll();
				long najvecaVrednost = 1;
				
				for (int i = 0; i < lista.size(); i++) {
					
					if (najvecaVrednost <= lista.get(i).getId()) {
						najvecaVrednost = lista.get(i).getId();
					}
					
					if (i == lista.size() - 1) {
						najvecaVrednost++;
					}
					
				}
				
				banka.setId(najvecaVrednost);
				savedBanka = service.save(banka);
				
			}
			
			URI uri = URI.create("/banka/" + savedBanka.getId());
			return ResponseEntity.created(uri).body(savedBanka);
		}
		
		
		//*********************************
		//		AZURIRAJ BANKU			  *
		//*********************************
		
		@PutMapping("/banka/{id}")
		public ResponseEntity<?> updateBanka(@RequestBody Banka banka, @PathVariable long id){
			
			if(service.existsById(id)) {
				
				banka.setId(id);
				Banka updateBanka = service.save(banka);
				
				return ResponseEntity.ok(updateBanka);
				
			} else {
				
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("Resource with requested id: " + id + " has not been found");
				
			}
		}
		
		//*********************************
		//		IZBRISI BANKU			  *
		//*********************************
		@DeleteMapping("/banka/{id}")
		public ResponseEntity<?> deleteBanka(@PathVariable long id) {
			
			if(service.existsById(id)) {
				
				service.deleteById(id);
				
				return ResponseEntity.ok("Resource with requested id: " + id + " has been deleted");
				
			}
			else {
				
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("Resource with requested id: " + id + " has not been found");
				
			}
		}
		
}
