package rva.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rva.model.Banka;
import rva.model.Filijala;
import rva.repository.FilijalaRepository;

@Service
public class FilijalaService {

	@Autowired 
	private FilijalaRepository repo;
	
	public List<Filijala> getAll(){
		return repo.findAll();
	}
	
	public Optional<Filijala> getById(long Id){
		return repo.findById(Id);
	}
	
	public Optional<List<Filijala>> getByAdresa(String adresa) {
		Optional<List<Filijala>> filijale = Optional.of(repo.findByAdresaContainingIgnoreCase(adresa));
		return filijale;
	}
	
	public List<Filijala> getBySearch(String search) {
		String searchEntry = search.toLowerCase();
		return repo.getBySearch(searchEntry);
	}
	
	//Trazenje po banci koja je strani kljuc u filijali
	/*public Optional<List<Filijala>> findFilijalaByBanka(Banka banka){
		Optional<List<Filijala>> filijale = Optional.of(repo.findByBanka(banka));
		return filijale;
	}*/
	
	public Filijala save(Filijala filijala) {
		return repo.save(filijala);
	}
	public boolean existsById(long id) {
		if(getById(id).isPresent()) {
			return true;
		} else {
			return false;
		}
	}
	public void deleteById(long id) {
		repo.deleteById(id);
	}
}
