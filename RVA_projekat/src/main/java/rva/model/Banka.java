package rva.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;


@Entity

public class Banka implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="BANKA_ID_GENERATOR", sequenceName="BANKA_SEQ", allocationSize = 1) 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BANKA_ID_GENERATOR") 
	private long id;
	private String naziv;
	private String kontakt;
	private int pib;
	
	@OneToMany(mappedBy="Banka")
	private List<Filijala> filijale;
	
	public Banka () {
		
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getKontakt() {
		return kontakt;
	}
	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}
	public int getPib() {
		return pib;
	}
	public void setPib(int pib) {
		this.pib = pib;
	}
	
	
	
}
