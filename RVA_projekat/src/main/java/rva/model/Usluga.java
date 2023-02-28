package rva.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Usluga implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="USLUGA_ID_GENERATOR", sequenceName="USLUGA_SEQ", allocationSize = 1) 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USLUGA_ID_GENERATOR") 
	private long id;
	private String naziv;
	private String opis_usluge;
	private Date datum_ugovora;
	private double provizija;
	
	@ManyToOne
	@JoinColumn(name="Filijala")
	private Filijala filijala;
	
	@ManyToOne
	@JoinColumn(name="Korisnik_usluge")
	private Korisnik_usluge korisnik_usluge;
	
	
	public Usluga() {
		
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
	public String getOpis_usluge() {
		return opis_usluge;
	}
	public void setOpis_usluge(String opis_usluge) {
		this.opis_usluge = opis_usluge;
	}
	public Date getDatum_ugovora() {
		return datum_ugovora;
	}
	public void setDatum_ugovora(Date datum_ugovora) {
		this.datum_ugovora = datum_ugovora;
	}
	public double getProvizija() {
		return provizija;
	}
	public void setProvizija(double provizija) {
		this.provizija = provizija;
	}
}
