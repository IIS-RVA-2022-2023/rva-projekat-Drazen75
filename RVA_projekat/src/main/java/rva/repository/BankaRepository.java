package rva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rva.model.Banka;

public interface BankaRepository extends JpaRepository<Banka, Long>{
	
	List<Banka> findByNazivContainingIgnoreCase(String naziv);
	
}
