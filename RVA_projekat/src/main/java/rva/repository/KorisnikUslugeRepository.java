package rva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rva.model.KorisnikUsluge;

public interface KorisnikUslugeRepository extends JpaRepository<KorisnikUsluge, Long>{
	
	public abstract List<KorisnikUsluge> findByImeOrPrezimeContainingIgnoreCase(String prezime);
	
	@Query("SELECT k FROM Korisnik_usluge k " +
		       "WHERE LOWER(k.ime) LIKE LOWER(CONCAT('%', :search, '%')) " +
		       "OR LOWER(k.prezime) LIKE LOWER(CONCAT('%', :search, '%'))")

	List<KorisnikUsluge> getBySearch(@Param("search") String search);
}
