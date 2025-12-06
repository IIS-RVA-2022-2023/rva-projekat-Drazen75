package rva.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rva.model.KorisnikUsluge;
import rva.service.KorisnikUslugeService;

@CrossOrigin
@RestController
public class KorisnikUslugeController {
	
	@Autowired
    private KorisnikUslugeService service;

    @GetMapping("/korisnikUsluge")
    public ResponseEntity<List<KorisnikUsluge>> getAllKorisnikUsluge() {
        List<KorisnikUsluge> korisnici = service.getAll();
        return new ResponseEntity<>(korisnici, HttpStatus.OK);
    }

    @GetMapping("/korisnikUsluge/{id}")
    public ResponseEntity<?> getKorisnikUslugeById(@PathVariable long id){
        if(service.existsById(id)){
            return ResponseEntity.ok(service.getById(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Korisnik_usluge with this ID does not exist");
        }
    }

    @GetMapping("/korisnikUsluge/prezime/{prezime}")
    public ResponseEntity<?> getKorisnikUslugeByPrezime(@PathVariable String prezime) {
        if(!service.getByPrezime(prezime).isEmpty()) {
            return ResponseEntity.ok(service.getByPrezime(prezime));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Korisnik_usluge with requested prezime (" + prezime + ") does not exist!");
        }
    }

    @GetMapping("korisnikUsluge/korisnikUslugeSearch/{search}")
    public ResponseEntity<?> getKorisnikUslugeBySearch(@PathVariable("search") String search){
        List<KorisnikUsluge> korisnici = service.getBySearch(search);
        if(korisnici.isEmpty())
            return new ResponseEntity<>(
                      "No similar korisnik_usluge found", 
                      HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.OK)
                .body(korisnici);
    }

    @PostMapping("/korisnikUsluge")
    public ResponseEntity<?> createKorisnikUsluge(@RequestBody KorisnikUsluge korisnikUsluge){
        KorisnikUsluge savedKorisnikUsluge;
        if(!service.existsById(korisnikUsluge.getId())) {
            savedKorisnikUsluge = service.save(korisnikUsluge);
        } else {
            List<KorisnikUsluge> lista = service.getAll();
            long najvecaVrednost = 1;

            for (int i = 0; i < lista.size(); i++) {
                if (najvecaVrednost <= lista.get(i).getId()) {
                    najvecaVrednost = lista.get(i).getId();
                }

                if (i == lista.size() - 1) {
                    najvecaVrednost++;
                }
            }

            korisnikUsluge.setId(najvecaVrednost);
            savedKorisnikUsluge = service.save(korisnikUsluge);
        }

        URI uri = URI.create("/korisnik_usluge/" + savedKorisnikUsluge.getId());
        return ResponseEntity.created(uri).body(savedKorisnikUsluge);
    }

    @PutMapping("/korisnikUsluge/{id}")
    public ResponseEntity<?> updateKorisnikUsluge(@RequestBody KorisnikUsluge korisnikUsluge, @PathVariable long id){
        if(service.existsById(id)) {
        	korisnikUsluge.setId(id);
        	KorisnikUsluge updateKorisnikUsluge = service.save(korisnikUsluge);
            return ResponseEntity.ok(updateKorisnikUsluge);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Resource with requested id: " + id + " has not been found");
        }
    }

    @DeleteMapping("/korisnikUsluge/{id}")
    public ResponseEntity<?> deleteKorisnikUsluge(@PathVariable long id) {
        if(service.existsById(id)) {
            service.deleteById(id);
            return ResponseEntity.ok("Resource with requested id: " + id + " has been deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("Resource with requested id: " + id + " has not been found");
        }
    }
}