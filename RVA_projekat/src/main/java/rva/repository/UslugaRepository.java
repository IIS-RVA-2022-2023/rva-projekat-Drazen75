package rva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rva.model.Usluga;

public interface UslugaRepository extends JpaRepository<Usluga, Long>{
	
	public abstract List<Usluga> findByNazivContainingIgnoreCase(String naziv);
	
	@Query(value = "SELECT u FROM Usluga u WHERE LOWER(u.naziv) LIKE LOWER(CONCAT('%', :search, '%'))")
	List<Usluga> getBySearch(@Param("search") String search);
	
}
