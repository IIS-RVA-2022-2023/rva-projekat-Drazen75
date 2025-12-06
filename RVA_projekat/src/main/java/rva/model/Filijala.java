package rva.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Filijala implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="FILIJALA_ID_GENERATOR", sequenceName="FILIJALA_SEQ", allocationSize = 1) 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FILIJALA_ID_GENERATOR") 
	private long id;
	private String adresa;
	private int broj_pultova;
	private boolean poseduje_sef;
	
	@ManyToOne
	@JoinColumn(name = "banka")
	private Banka banka;
	
	@OneToMany(mappedBy="filijala")
	private List<Usluga> usluge;
	
	
	public Filijala() {
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public int getBroj_pultova() {
		return broj_pultova;
	}
	public void setBroj_pultova(int broj_pultova) {
		this.broj_pultova = broj_pultova;
	}
	public boolean isPoseduje_sef() {
		return poseduje_sef;
	}
	public void setPoseduje_sef(boolean poseduje_sef) {
		this.poseduje_sef = poseduje_sef;
	}
	//******************
	// Strani kljuc
	//******************
	public Banka getBanka() {
		return banka;
	}
	public void setBanka(Banka banka) {
		this.banka = banka;
	}
}
