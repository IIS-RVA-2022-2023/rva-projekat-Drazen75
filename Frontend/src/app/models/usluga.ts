import { Filijala } from "./filijala";
import { KorisnikUsluge } from "./korisnikUsluge";

export class Usluga {
  id!: number;
  naziv!: string;
  opis_usluge!: string;
  datum_ugovora!: Date;
  provizija!: number;
  filijala!: Filijala;
  korisnikUsluge!: KorisnikUsluge;  
}