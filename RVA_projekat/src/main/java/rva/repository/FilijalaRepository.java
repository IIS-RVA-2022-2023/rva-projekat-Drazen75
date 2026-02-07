package rva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rva.model.Banka;
import rva.model.Filijala;

public interface FilijalaRepository extends JpaRepository<Filijala, Long>{
public abstract List<Filijala> findByAdresaContainingIgnoreCase(String adresa);
	
	@Query(value = "SELECT f FROM Filijala f WHERE LOWER(f.adresa) LIKE LOWER(CONCAT('%', :search, '%'))")
	List<Filijala> getBySearch(@Param("search") String search);
	//List<Filijala> findByBanka(Banka banka);
}
