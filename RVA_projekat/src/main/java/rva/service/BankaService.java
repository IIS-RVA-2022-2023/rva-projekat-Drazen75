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
		
		public List<Banka> findAll(){
			return repo.findAll();
		}
		
		public Optional<Banka> findById(long id){
			return repo.findById(id);
		}
		
		public Optional<List<Banka>> findByNaziv(String naziv){
				Optional<List<Banka>> lista = Optional.of(repo.findByNazivContainingIgnoreCase(naziv));
				return lista;
		}
		
		public Banka save(Banka banka) {
			return repo.save(banka);
		}
		
		public boolean existsById(long id) {
			if(findById(id).isPresent()){
				return true;
			} else {
				return false;
			}
		}
		
		public void deleteById(long id) {
			repo.deleteById(id);
		}
}
