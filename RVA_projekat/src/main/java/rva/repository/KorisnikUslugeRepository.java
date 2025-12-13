package rva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rva.model.KorisnikUsluge;

public interface KorisnikUslugeRepository extends JpaRepository<KorisnikUsluge, Long>{
	
	public abstract List<KorisnikUsluge> findByImeContainingIgnoreCase(String ime);
	
	@Query("SELECT k FROM KorisnikUsluge k " +
		       "WHERE LOWER(k.ime) LIKE LOWER(CONCAT('%', :search, '%'))")

	List<KorisnikUsluge> getBySearch(@Param("search") String search);
}
