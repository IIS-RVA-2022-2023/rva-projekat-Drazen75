	insert into banka(id, naziv, kontakt, PIB)
	values (nextval('BANKA_SEQ'), 'Unicredit bank A.D.Beograd', '011 3777888', 100000170);
	
	insert into banka(id, naziv, kontakt, PIB)
	values (nextval('BANKA_SEQ'), 'NLB Komercijalna banka', '0700 800900', 100001931);
	
	insert into banka(id, naziv, kontakt, PIB)
	values (nextval('BANKA_SEQ'), 'Raiffeisen bank', '011 3202 100', 100000299);
	
	insert into banka(id, naziv, kontakt, PIB)
	values (nextval('BANKA_SEQ'), 'Vojvodjanska banka', '0700 480400', 102398907);
	
	insert into banka(id, naziv, kontakt, PIB)
	values (nextval('BANKA_SEQ'), 'Banca Intesa', '011 3108888', 100001159);
	
	insert into banka(id, naziv, kontakt, PIB)
	values (nextval('BANKA_SEQ'), 'ProCredit banka', '011 2057000', 100000215);
	
	insert into banka(id, naziv, kontakt, PIB)
	values (nextval('BANKA_SEQ'), 'ERSTE banka', '0800 201201', 101626723);
	
	insert into banka(id, naziv, kontakt, PIB)
	values (nextval('BANKA_SEQ'), 'OTP banka', '011 13011555', 100584604);
	
	
	
	insert into "korisnikUsluge"(id, ime, prezime, maticni_broj)
	values (nextval('KORISNIK_USLUGE_SEQ'), 'Filip', 'Nikolic', '2108001810033');
	
	insert into "korisnikUsluge"(id, ime, prezime, maticni_broj)
	values (nextval('KORISNIK_USLUGE_SEQ'), 'Drazen', 'Kopuz', '0811001103251');
	
	insert into "korisnikUsluge"(id, ime, prezime, maticni_broj)
	values (nextval('KORISNIK_USLUGE_SEQ'), 'Vuk', 'Stojic', '1909001153145');
	
	insert into "korisnikUsluge"(id, ime, prezime, maticni_broj)
	values (nextval('KORISNIK_USLUGE_SEQ'), 'Danilo', 'Radivojevic', '2404001513545');
	
	insert into "korisnikUsluge"(id, ime, prezime, maticni_broj)
	values (nextval('KORISNIK_USLUGE_SEQ'), 'Ivan', 'Kukricar', '2004001543854');
	
	insert into "korisnikUsluge"(id, ime, prezime, maticni_broj)
	values (nextval('KORISNIK_USLUGE_SEQ'), 'Darko', 'Mihic', '3003001542635');
	
	insert into "korisnikUsluge"(id, ime, prezime, maticni_broj)
	values (nextval('KORISNIK_USLUGE_SEQ'), 'Lazar', 'Popovic', '1307001152635');
	
	insert into "korisnikUsluge"(id, ime, prezime, maticni_broj)
	values (nextval('KORISNIK_USLUGE_SEQ'), 'Milos', 'Starcevic', '0506001261538');
	
	
	
	insert into Filijala(id, adresa, broj_pultova, poseduje_sef, banka)
	values(nextval('FILIJALA_SEQ'), 'Rajiceva 27', 4, true, 1);
	
	insert into Filijala(id, adresa, broj_pultova, poseduje_sef, banka)
	values(nextval('FILIJALA_SEQ'), 'Sutjeska 3', 2, false, 2);
	
	insert into Filijala(id, adresa, broj_pultova, poseduje_sef, banka)
	values(nextval('FILIJALA_SEQ'), 'Pozorisni trg 3', 3, false, 3);
	
	insert into Filijala(id, adresa, broj_pultova, poseduje_sef, banka)
	values(nextval('FILIJALA_SEQ'), 'Bulevar Oslobodjenja 80', 4, true, 4);
	
	insert into Filijala(id, adresa, broj_pultova, poseduje_sef, banka)
	values(nextval('FILIJALA_SEQ'), 'Bulevar Mihajla Pupina 4a', 3, true, 5);
	
	insert into Filijala(id, adresa, broj_pultova, poseduje_sef, banka)
	values(nextval('FILIJALA_SEQ'), 'Bulevar cara Lazara 7b', 2, false, 6);
	
	insert into Filijala(id, adresa, broj_pultova, poseduje_sef, banka)
	values(nextval('FILIJALA_SEQ'), 'Bulevar cara Lazara 19', 4, true, 7);
	
	insert into Filijala(id, adresa, broj_pultova, poseduje_sef, banka)
	values(nextval('FILIJALA_SEQ'), 'Trg slobode 5', 2, false, 8);
	
	
	
	insert into Usluga(id, naziv, opis_usluge, datum_ugovora, provizija, filijala, korisnik_usluge)
	values(nextval('USLUGA_SEQ'), 'Vodjenje racuna', 'Studentski paket', to_date('25.11.2019.', 'dd.mm.yyyy'), 1, 1, 2);
	
	insert into Usluga(id, naziv, opis_usluge, datum_ugovora, provizija, filijala, korisnik_usluge)
	values(nextval('USLUGA_SEQ'), 'Mobilno bankarstvo', 'Bez provizije za placanje putem mobilne aplikacije', to_date('15.05.2020.', 'dd.mm.yyyy'), 1, 2, 1);
	
	insert into Usluga(id, naziv, opis_usluge, datum_ugovora, provizija, filijala, korisnik_usluge)
	values(nextval('USLUGA_SEQ'), 'Elektronsko placanje', 'Maksimalno 10 naloga dnevno', to_date('06.10.2021.', 'dd.mm.yyyy'), 5, 3, 3);
	
	insert into Usluga(id, naziv, opis_usluge, datum_ugovora, provizija, filijala, korisnik_usluge)
	values(nextval('USLUGA_SEQ'), 'Vodjenje racuna', 'Paket fizicko lice', to_date('23.11.2016.', 'dd.mm.yyyy'), 10, 4, 4);
	
	insert into Usluga(id, naziv, opis_usluge, datum_ugovora, provizija, filijala, korisnik_usluge)
	values(nextval('USLUGA_SEQ'), 'Vodjenje racuna', 'Paket pravno lice', to_date('16.03.2022.', 'dd.mm.yyyy'), 7, 5, 5);
	
	insert into Usluga(id, naziv, opis_usluge, datum_ugovora, provizija, filijala, korisnik_usluge)
	values(nextval('USLUGA_SEQ'), 'Stednja', 'Paket fizicko lice', to_date('18.06.2021.', 'dd.mm.yyyy'), 5, 6, 6);
	
	insert into Usluga(id, naziv, opis_usluge, datum_ugovora, provizija, filijala, korisnik_usluge)
	values(nextval('USLUGA_SEQ'), 'Kredit', 'Stambeni kredit za fizicka lica', to_date('30.06.2020.', 'dd.mm.yyyy'), 8, 7, 7);
	
	insert into Usluga(id, naziv, opis_usluge, datum_ugovora, provizija, filijala, korisnik_usluge)
	values(nextval('USLUGA_SEQ'), 'Elektronsko placanje', 'Neogranicen broj naloga', to_date('21.07.2021.', 'dd.mm.yyyy'), 4, 8, 8);
	
	
