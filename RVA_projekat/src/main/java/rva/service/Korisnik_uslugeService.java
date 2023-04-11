package rva.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rva.model.Korisnik_usluge;
import rva.repository.KorisnikUslugeRepository;

@Service
public class Korisnik_uslugeService {
	
	@Autowired
	private KorisnikUslugeRepository repo;
	
}
