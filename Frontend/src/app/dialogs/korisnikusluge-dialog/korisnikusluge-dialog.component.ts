import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { KorisnikUsluge } from '../../models/korisnikUsluge';
import { KorisnikUslugeService } from '../../services/korisnik_usluge.service';
import { Filijala } from 'src/app/models/filijala';
import { Subscription } from 'rxjs';
import { Usluga } from 'src/app/models/usluga';
import { FilijalaService } from 'src/app/services/filijala.service';
import { UslugaService } from 'src/app/services/usluga.service';

@Component({
  selector: 'app-korisnikUsluge-dialog',
  templateUrl: './korisnikUsluge-dialog.component.html',
  styleUrls: ['./korisnikUsluge-dialog.component.css']
})
export class KorisnikUslugeDialogComponent {
  public flagArtDialog!: number;
  private subscription!: Subscription;
  isLoading: any;
  /* public filijale!: Filijala[];
  public usluge!: Usluga[]; */

  constructor(
    public snackBar: MatSnackBar,
    public korisnikUslugeService: KorisnikUslugeService,
    @Inject(MAT_DIALOG_DATA) public data: KorisnikUsluge,
    public dialogRef: MatDialogRef<KorisnikUslugeDialogComponent>
  ) { }
  /* public filijalaService: FilijalaService,
  public uslugaService: UslugaService) */

  /* ngOnInit() {
    this.subscription = this.filijalaService.getAllFilijala().subscribe(filijalaData => { this.filijale = filijalaData });
    this.subscription = this.uslugaService.getAllUsluga().subscribe(uslugaData => { this.usluge = uslugaData });
  }

  compareTo(a: any, b: any) {
    return a.id == b.id;
  } */

  public add(): void {
    if (this.isLoading) return; // Prevent double-clicks
    this.isLoading = true;

    console.log("Adding korisnik usluge:", JSON.stringify(this.data, null, 2));

    this.korisnikUslugeService.addKorisnikUsluge(this.data).subscribe({
      next: (response) => {
        console.log("Add SUCCESS - Response:", response);
        this.isLoading = false;
        this.snackBar.open('Uspešno dodat korisnik usluge: ' + this.data.ime + ' ' + this.data.prezime, 'OK', {
          duration: 2500
        });
        this.dialogRef.close(true);
      },
      error: (error) => {
        console.error("Add ERROR - Full error object:", error);
        console.error("Error status:", error.status);
        console.error("Error message:", error.message);
        console.error("Error body:", error.error);
        this.isLoading = false;
        this.snackBar.open('Došlo je do greške prilikom dodavanja novog korisnika usluge.', 'Zatvori', {
          duration: 2500
        });
      }
    });
  }


  public update(): void {
    if (this.isLoading) return;
    this.isLoading = true;
    console.log('ID koji saljem:', this.data.id);

    console.log("Updating korisnik usluge:", JSON.stringify(this.data, null, 2));

    this.korisnikUslugeService.updateKorisnikUsluge(this.data).subscribe({
      next: (response) => {
        console.log("Update SUCCESS - Response:", response);
        this.isLoading = false;
        this.snackBar.open('Uspešno izmenjen korisnik usluge: ' + this.data.ime + ' ' + this.data.prezime, 'OK', {
          duration: 2500
        });
        this.dialogRef.close(true);
      },
      error: (error) => {
        console.error("Update ERROR - Full error object:", error);
        console.error("Error status:", error.status);
        console.error("Error message:", error.message);
        console.error("Error body:", error.error);
        this.isLoading = false;
        this.snackBar.open('Došlo je do greške prilikom izmene korisnika usluge.', 'Zatvori', {
          duration: 2500
        });
      }
    });
  }

  public delete(): void {
    if (this.isLoading) return;
    this.isLoading = true;

    console.log('Deleting korisnik usluge - ID:', this.data.id);

    this.korisnikUslugeService.deleteKorisnikUsluge(this.data.id).subscribe({
      next: (response) => {
        console.log("Delete SUCCESS - Response:", response);
        this.isLoading = false;
        this.snackBar.open('Uspešno obrisan korisnik usluge: ' + this.data.ime + ' ' + this.data.prezime, 'OK', {
          duration: 2500
        });
        this.dialogRef.close(true);
      },
      error: (error) => {
        console.error("Delete ERROR - Full error object:", error);
        console.error("Error status:", error.status);
        console.error("Error message:", error.message);
        console.error("Error body:", error.error);
        this.isLoading = false;
        this.snackBar.open('Došlo je do greške prilikom brisanja korisnika usluge.', 'Zatvori', {
          duration: 2500
        });
      }
    });
  }

  public cancel(): void {
    this.dialogRef.close();
    this.snackBar.open('Odustali ste od izmene. ', 'Zatvori', {
      duration: 1000
    })
  }
}