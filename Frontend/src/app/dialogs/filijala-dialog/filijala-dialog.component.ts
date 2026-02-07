import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Filijala } from '../../models/filijala';
import { FilijalaService } from '../../services/filijala.service';
import { Subscription } from 'rxjs';
import { Banka } from 'src/app/models/banka';
import { BankaService } from 'src/app/services/banka.service';

@Component({
  selector: 'app-filijala-dialog',
  templateUrl: './filijala-dialog.component.html',
  styleUrls: ['./filijala-dialog.component.css']
})
export class FilijalaDialogComponent {

  public flagArtDialog!: number;
  private subscription!: Subscription;
  public banke!: Banka[];
  isLoading: any;


  constructor(public snackBar: MatSnackBar,
    public filijalaService: FilijalaService,
    @Inject(MAT_DIALOG_DATA) public data: Filijala,
    public dialogRef: MatDialogRef<FilijalaDialogComponent>,
    public bankaService: BankaService) { }


  ngOnInit() {
    this.subscription = this.bankaService.getAllBanka().subscribe(bankaData => { this.banke = bankaData });

  }

  compareTo(a: any, b: any) {
    return a.id == b.id;
  }

  public add(): void {
    if (this.isLoading) return; // Prevent double-clicks
    this.isLoading = true;

    console.log("Adding filijala:", JSON.stringify(this.data, null, 2));

    this.filijalaService.addFilijala(this.data).subscribe({
      next: (response) => {
        console.log("Add SUCCESS - Response:", response);
        this.isLoading = false;
        this.snackBar.open('Uspešno dodata filijala: ' + this.data.adresa, 'OK', {
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
        this.snackBar.open('Došlo je do greške prilikom dodavanja nove filijale.', 'Zatvori', {
          duration: 2500
        });
      }
    });
  }



  public update(): void {
    if (this.isLoading) return;
    this.isLoading = true;
    console.log('ID koji saljem:', this.data.id);

    console.log("Updating filijala:", JSON.stringify(this.data, null, 2));

    this.filijalaService.updateFilijala(this.data).subscribe({
      next: (response) => {
        console.log("Update SUCCESS - Response:", response);
        this.isLoading = false;
        this.snackBar.open('Uspešno izmenjena filijala: ' + this.data.adresa, 'OK', {
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
        this.snackBar.open('Došlo je do greške prilikom izmene filijale.', 'Zatvori', {
          duration: 2500
        });
      }
    });
  }

  public delete(): void {
    if (this.isLoading) return;
    this.isLoading = true;

    console.log('Deleting filijala - ID:', this.data.id);

    this.filijalaService.deleteFilijala(this.data.id).subscribe({
      next: (response) => {
        console.log("Delete SUCCESS - Response:", response);
        this.isLoading = false;
        this.snackBar.open('Uspešno obrisana filijala: ' + this.data.adresa, 'OK', {
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
        this.snackBar.open('Došlo je do greške prilikom brisanja filijale.', 'Zatvori', {
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