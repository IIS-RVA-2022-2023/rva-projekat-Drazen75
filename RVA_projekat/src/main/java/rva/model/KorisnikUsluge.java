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
public class KorisnikUsluge implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="KORISNIK_USLUGE_ID_GENERATOR", sequenceName="KORISNIK_USLUGE_SEQ", allocationSize = 1) 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "KORISNIK_USLUGE_ID_GENERATOR") 
	private long id;
	private String ime;
	private String prezime;
	private String maticni_broj;
	
	@OneToMany(mappedBy="korisnikUsluge")
	private List<Usluga> usluge;
	
	public KorisnikUsluge() {
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getMaticni_broj() {
		return maticni_broj;
	}
	public void setMaticni_broj(String maticni_broj) {
		this.maticni_broj = maticni_broj;
	}

}
