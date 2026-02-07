package rva.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;


@Entity

public class Banka implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="BANKA_ID_GENERATOR", sequenceName="BANKA_SEQ", allocationSize = 1) 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BANKA_ID_GENERATOR") 
	private long id;
	private String naziv;
	private String kontakt;
	private int pib;
	
	@JsonIgnore
	@OneToMany(mappedBy="banka", cascade = CascadeType.REMOVE)
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
