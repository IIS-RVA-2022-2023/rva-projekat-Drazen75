package rva.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rva.model.Usluga;
import rva.repository.UslugaRepository;

@Service
public class UslugaService {

	 @Autowired
	    private UslugaRepository repo;

	    public List<Usluga> getAll() {
	        return repo.findAll();
	    }

	    public Optional<Usluga> getById(long id) {
	        return repo.findById(id);
	    }

	    public Optional<List<Usluga>> getByNaziv(String naziv) {
	        Optional<List<Usluga>> usluge = Optional.of(repo.findByNazivContainingIgnoreCase(naziv));
	        return usluge;
	    }

	    public List<Usluga> getBySearch(String search) {
	        String searchEntry = search.toLowerCase();
	        return repo.getBySearch(searchEntry);
	    }

	    public Usluga save(Usluga usluga) {
	        return repo.save(usluga);
	    }

	    public boolean existsById(long id) {
	        return repo.existsById(id);
	    }

	    public void deleteById(long id) {
	        repo.deleteById(id);
	    }
	}