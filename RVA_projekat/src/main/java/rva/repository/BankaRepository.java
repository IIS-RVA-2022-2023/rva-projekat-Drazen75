package rva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rva.model.Banka;

public interface BankaRepository extends JpaRepository<Banka, Long> {

	public abstract List<Banka> findByNazivContainingIgnoreCase(String naziv);

	@Query("SELECT b FROM Banka b WHERE LOWER(b.naziv) LIKE LOWER(CONCAT('%', :search, '%'))")
	List<Banka> getBySearch(@Param("search") String search);


}