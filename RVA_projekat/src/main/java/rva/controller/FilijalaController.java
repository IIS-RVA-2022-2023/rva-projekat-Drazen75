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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rva.model.Filijala;
import rva.service.FilijalaService;

@CrossOrigin
@RestController
@RequestMapping("filijala")
public class FilijalaController {
	
	@Autowired
	private FilijalaService service;
	
	@GetMapping("/filijala")
	public ResponseEntity<List<Filijala>> getAllFilijala() {
        
        // Your business logic here
		List<Filijala> filijale = service.getAll();
		return new ResponseEntity<>(filijale, HttpStatus.OK);
	}
	
	@GetMapping("/filijala/{id}")
	public ResponseEntity<?> getFilijalaById(@PathVariable long id){
		if(service.existsById(id)){
			return ResponseEntity.ok(service.getById(id));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filijala with this ID does not exist");
		}
	}
	
	@GetMapping("/filijala/adresa/{adresa}")
	public ResponseEntity<?> getFilijalaByNaziv(@PathVariable String adresa) {
		
		if(!service.getByAdresa(adresa).isEmpty()) {
			
			return ResponseEntity.ok(service.getByAdresa(adresa));
			
		} else {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Filijala with requested adresa ( " + adresa + " ) does not exist!");
			
		}
		
	}
	
	@GetMapping("filijala/filijalaSearch/{search}")
	public  ResponseEntity<?> getFilijalaBySearch(@PathVariable("search") String search){
		List<Filijala> filijale = service.getBySearch(search);
		if(filijale.isEmpty())
			return new ResponseEntity<>(
			          "Ni jedna slicna filijala ne postoji", 
			          HttpStatus.NOT_FOUND);
		return ResponseEntity.status(HttpStatus.OK)
		        .body(filijale);
	}
	
	@PostMapping("/filijala")
	public ResponseEntity<?> createFilijala(@RequestBody Filijala filijala){
		Filijala savedFilijala;
		if(!service.existsById(filijala.getId())) {
			
			savedFilijala = service.save(filijala);
			
		} else {
			
			List<Filijala> lista = service.getAll();
			long najvecaVrednost = 1;
			
			for (int i = 0; i < lista.size(); i++) {
				
				if (najvecaVrednost <= lista.get(i).getId()) {
					najvecaVrednost = lista.get(i).getId();
				}
				
				if (i == lista.size() - 1) {
					najvecaVrednost++;
				}
				
			}
			
			filijala.setId(najvecaVrednost);
			savedFilijala = service.save(filijala);
			
		}
		
		URI uri = URI.create("/filijala/" + savedFilijala.getId());
		return ResponseEntity.created(uri).body(savedFilijala);
		
	}
	
	@PutMapping("/filijala/{id}")
	public ResponseEntity<?> updateFilijala(@RequestBody Filijala filijala, @PathVariable long id){
		
		if(service.existsById(id)) {
			
			filijala.setId(id);
			Filijala updateFilijala = service.save(filijala);
			
			return ResponseEntity.ok(updateFilijala);
			
		} else {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Resource with requested id: " + id + " has not been found");
			
		}
	}
	
	@DeleteMapping("/filijala/{id}")
	public ResponseEntity<?> deleteFilijala(@PathVariable long id) {
		
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