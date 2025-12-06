package rva.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rva.model.KorisnikUsluge;
import rva.repository.KorisnikUslugeRepository;


@Service
public class KorisnikUslugeService {
	
	@Autowired
	private KorisnikUslugeRepository repo;
	
	public List<KorisnikUsluge> getAll() {
        return repo.findAll();
    }
    
    public Optional<KorisnikUsluge> getById(long id){
        return repo.findById(id);
    }
    
    public Optional<List<KorisnikUsluge>> getByPrezime(String prezime) {
        Optional<List<KorisnikUsluge>> korisnici = Optional.of(repo.findByImeOrPrezimeContainingIgnoreCase(prezime));
        return korisnici;
    }
    
    public List<KorisnikUsluge> getBySearch(String search) {
        String searchEntry = search.toLowerCase();
        return repo.getBySearch(searchEntry);
    }
    
    public KorisnikUsluge save(KorisnikUsluge korisnikUsluge) {
        return repo.save(korisnikUsluge);
    }
    
    public boolean existsById(long id) {
        if(repo.existsById(id)) {
            return true;
        } else return false;
    }
    
    public void deleteById(long id) {
        repo.deleteById(id);
    }
}