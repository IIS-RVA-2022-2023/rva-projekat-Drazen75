import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { UslugaService } from 'src/app/services/usluga.service';
import { Usluga } from 'src/app/models/usluga';
import { MatSnackBar } from '@angular/material/snack-bar';
import { KorisnikUslugeService } from 'src/app/services/korisnik_usluge.service';
import { FilijalaService } from 'src/app/services/filijala.service';
import { Subscription } from 'rxjs';
import { Filijala } from 'src/app/models/filijala';
import { Korisnik_usluge } from 'src/app/models/korisnik_usluge';
import { MatFormFieldModule } from "@angular/material/form-field";

@Component({
  selector: 'app-usluga-dialog',
  templateUrl: './usluga-dialog.component.html',
  styleUrls: ['./usluga-dialog.component.css']
})
export class UslugaDialogComponent {
  public flagArtDialog!: number;
  private subscription!: Subscription;
  public filijale!: Filijala[]
  public korsniciUsluge!: Korisnik_usluge[];
  isLoading: any;

  constructor(public snackBar: MatSnackBar,
    public uslugaService : UslugaService,
    @Inject(MAT_DIALOG_DATA) public data: Usluga,
    public dialogRef: MatDialogRef<UslugaDialogComponent>,
    public korisnkUslugeService: KorisnikUslugeService,
    public filijalaService: FilijalaService) { }

    ngOnInit() {
      this.subscription = this.filijalaService.getAllFilijala().subscribe(filijalaData => { this.filijale = filijalaData });
      this.subscription = this.korisnkUslugeService.getAllKorisnikUsluge().subscribe(korisnikUslugeData => { this.korsniciUsluge = korisnikUslugeData });
    }

    compareTo(a: any, b: any) {
      return a.id == b.id;
    }

   public add(): void {
    if (this.isLoading) return; // Prevent double-clicks
    this.isLoading = true;

    console.log("Adding usluga:", JSON.stringify(this.data, null, 2));

    this.uslugaService.addUsluga(this.data).subscribe({
      next: (response) => {
        console.log("Add SUCCESS - Response:", response);
        this.isLoading = false;
        this.snackBar.open('Uspešno dodata usluga: ' + this.data.naziv, 'OK', {
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
        this.snackBar.open('Došlo je do greške prilikom dodavanja nove usluge.', 'Zatvori', {
          duration: 2500
        });
      }
    });
  }


  public update(): void {
    if (this.isLoading) return;
    this.isLoading = true;
    console.log('ID koji saljem:', this.data.id);

    console.log("Updating usluga:", JSON.stringify(this.data, null, 2));

    this.uslugaService.updateUsluga(this.data).subscribe({
      next: (response) => {
        console.log("Update SUCCESS - Response:", response);
        this.isLoading = false;
        this.snackBar.open('Uspešno izmenjena usluga: ' + this.data.naziv, 'OK', {
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
        this.snackBar.open('Došlo je do greške prilikom izmene usluge.', 'Zatvori', {
          duration: 2500
        });
      }
    });
  }

  public delete(): void {
    if (this.isLoading) return;
    this.isLoading = true;

    console.log('Deleting usluga - ID:', this.data.id);

    this.uslugaService.deleteUsluga(this.data.id).subscribe({
      next: (response) => {
        console.log("Delete SUCCESS - Response:", response);
        this.isLoading = false;
        this.snackBar.open('Uspešno obrisana usluga: ' + this.data.naziv, 'OK', {
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
        this.snackBar.open('Došlo je do greške prilikom brisanja usluge.', 'Zatvori', {
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