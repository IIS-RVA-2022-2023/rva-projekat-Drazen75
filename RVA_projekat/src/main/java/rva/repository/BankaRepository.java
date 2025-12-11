package rva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rva.model.Banka;

import java.util.List;

@Repository
public interface BankaRepository extends JpaRepository<Banka, Long> {

	public abstract List<Banka> findByNazivContainingIgnoreCase(String naziv);

	@Query(value = "SELECT b FROM Banka b WHERE LOWER(b.naziv) LIKE LOWER(CONCAT('%', :search, '%'))")
	List<Banka> getBySearch(@Param("search") String search);


}