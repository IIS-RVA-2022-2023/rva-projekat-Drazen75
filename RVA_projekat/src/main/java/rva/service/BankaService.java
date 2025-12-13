package rva.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rva.model.Banka;
import rva.repository.BankaRepository;

@Service
public class BankaService {

		@Autowired
		private BankaRepository repo;
		
		public List<Banka> getAll(){
			return repo.findAll();
		}
		
		public Optional<Banka> getById(long id){
			return repo.findById(id);
		}
		
		public Optional<List<Banka>> getByNaziv(String naziv){
				Optional<List<Banka>> banke = Optional.of(repo.findByNazivContainingIgnoreCase(naziv));
				return banke;
		}
		
		public List<Banka> getBySearch(String search) {
			String searchEntry = search.toLowerCase();
			return repo.getBySearch(searchEntry);
		}
		
		public Banka save(Banka banka) {
			return repo.save(banka);
		}
		
		public boolean existsById(long id) {
			if(repo.existsById(id)){
				return true;
			} else {
				return false;
			}
		}
		
		public void deleteById(long id) {
			repo.deleteById(id);
		}
}
