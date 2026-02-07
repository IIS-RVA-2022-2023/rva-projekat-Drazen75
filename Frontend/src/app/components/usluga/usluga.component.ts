import { Component, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Subscription } from 'rxjs';
import { UslugaDialogComponent } from 'src/app/dialogs/usluga-dialog/usluga-dialog.component';
import { Usluga } from 'src/app/models/usluga';

import { UslugaService } from 'src/app/services/usluga.service';

@Component({
  selector: 'app-usluga',
  templateUrl: './usluga.component.html',
  styleUrls: ['./usluga.component.css']
})
export class UslugaComponent {
    subscription!: Subscription;
    displayedColumns = ['id', 'datum_ugovora', 'naziv', 'opis_usluge', 'provizija', 'filijala', 'korisnik_usluge', 'actions'];
    data!: MatTableDataSource<Usluga>;
    selektovanaUsluga!: Usluga;
    @ViewChild(MatSort, { static: false }) sort!: MatSort;
    @ViewChild(MatPaginator, { static: false }) paginator!: MatPaginator;

    constructor(private uslugaService: UslugaService, private dialog: MatDialog) {}
    
      ngOnInit(): void {
        this.loadData();
      }

      ngOnDestroy(): void {
        this.subscription.unsubscribe();
      }
    
      ngOnChanges(): void {
        this.loadData(); 
      }


      loadData(): void {
    this.uslugaService.getAllUsluga().subscribe(
      data => {
        // Log the data to the console
        console.log('Data received from getAllUsluga:', data);
        
        this.data = new MatTableDataSource(data);
        this.data.sort = this.sort;
        this.data.paginator = this.paginator;
      },
      error => {
        console.log('Error:', error.name + ' ' + error.message);
      }
    );
  }

  public openDialog(flag: number, usluga?: Usluga): void {
      console.log('Usluga passed to dialog:', usluga);
      const dialogRef = this.dialog.open(UslugaDialogComponent, {
        data: (usluga ? usluga : new Usluga())
      });
  
      dialogRef.componentInstance.flagArtDialog = flag;
  
      dialogRef.afterClosed().subscribe(res => {
        if (res == 1) this.loadData();
      });
  }
  
  
    selectRow(row: Usluga) {
      this.selektovanaUsluga = row;
      console.log("click")
    }
  
    applyFilter(filterValue: any) {
      filterValue = filterValue.target.value
      filterValue = filterValue.trim();
      filterValue = filterValue.toLocaleLowerCase();
      this.data.filter = filterValue; //    JaBuKa    --> JaBuKa --> jabuka
    }
  
  
    
    
}
