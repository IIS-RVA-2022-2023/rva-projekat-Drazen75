import { Filijala } from "./filijala";
import { Korisnik_usluge } from "./korisnik_usluge";

export class Usluga {
  id!: number;
  naziv!: string;
  opis_usluge!: string;
  datum_ugovora!: Date;
  provizija!: number;
  filijala!: Filijala;
  korsinik_usluge!: Korisnik_usluge;  
}