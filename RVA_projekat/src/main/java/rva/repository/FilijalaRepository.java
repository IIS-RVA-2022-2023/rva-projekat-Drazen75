package rva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rva.model.Filijala;

public interface FilijalaRepository extends JpaRepository<Filijala, Long>{
	List<Filijala> findByPoseduje_sefIsTrue();
	List<Filijala> findByBroj_pultovaGreaterThan();
	/*List<Filijala> findByAdresa();
	List<Filijala> findByBanka();*/
}
