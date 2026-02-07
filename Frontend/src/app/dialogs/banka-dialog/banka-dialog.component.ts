import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Banka } from '../../models/banka';
import { BankaService } from '../../services/banka.service';

@Component({
  selector: 'app-banka-dialog',
  templateUrl: './banka-dialog.component.html',
  styleUrls: ['./banka-dialog.component.css']
})
export class BankaDialogComponent {
  public flagArtDialog!: number;
  public isLoading = false; // Track loading state

  constructor(
    public snackBar: MatSnackBar,
    public bankaService: BankaService,
    @Inject(MAT_DIALOG_DATA) public data: Banka,
    public dialogRef: MatDialogRef<BankaDialogComponent>
  ) { }

  public add(): void {
    if (this.isLoading) return; // Prevent double-clicks
    this.isLoading = true;

    console.log("Adding bank:", JSON.stringify(this.data, null, 2));

    this.bankaService.addBanka(this.data).subscribe({
      next: (response) => {
        console.log("Add SUCCESS - Response:", response);
        this.isLoading = false;
        this.snackBar.open('Uspešno dodata banka: ' + this.data.naziv, 'OK', {
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
        this.snackBar.open('Došlo je do greške prilikom dodavanja nove banke.', 'Zatvori', {
          duration: 2500
        });
      }
    });
  }

  public update(): void {
    if (this.isLoading) return;
    this.isLoading = true;
    console.log('ID koji saljem:', this.data.id);

    console.log("Updating bank:", JSON.stringify(this.data, null, 2));

    this.bankaService.updateBanka(this.data).subscribe({
      next: (response) => {
        console.log("Update SUCCESS - Response:", response);
        this.isLoading = false;
        this.snackBar.open('Uspešno izmenjena banka: ' + this.data.naziv, 'OK', {
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
        this.snackBar.open('Došlo je do greške prilikom izmene banke.', 'Zatvori', {
          duration: 2500
        });
      }
    });
  }

  public delete(): void {
    if (this.isLoading) return;
    this.isLoading = true;

    console.log('Deleting bank - ID:', this.data.id);

    this.bankaService.deleteBanka(this.data.id).subscribe({
      next: (response) => {
        console.log("Delete SUCCESS - Response:", response);
        this.isLoading = false;
        this.snackBar.open('Uspešno obrisana banka: ' + this.data.naziv, 'OK', {
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
        this.snackBar.open('Došlo je do greške prilikom brisanja banke.', 'Zatvori', {
          duration: 2500
        });
      }
    });
  }

  public cancel(): void {
    this.dialogRef.close();
    this.snackBar.open('Odustali ste od izmene.', 'Zatvori', {
      duration: 1000
    });
  }
}