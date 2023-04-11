package rva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rva.model.Filijala;
import rva.service.FilijalaService;

@RestController
@RequestMapping("filijala")
public class FilijalaController {
	
	@Autowired
	private FilijalaService service;
	@GetMapping
	private ResponseEntity<List<Filijala>> getAllFilijala(){
		return ResponseEntity.ok(service.getAll());
	}
}
