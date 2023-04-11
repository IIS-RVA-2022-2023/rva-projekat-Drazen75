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
	
	//Numericko obelezje 
	public Optional<List<Filijala>> getByPosduje_sefTrue(){
		return Optional.of(repo.findByPoseduje_sefIsTrue());
		
	}
	
	
	/*public Optional<List<Filijala>> getByBanka() {
		return Optional.of(repo.findByBanka());
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
