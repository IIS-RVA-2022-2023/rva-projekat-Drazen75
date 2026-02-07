import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Korisnik_uslugeComponent } from './korisnik-usluge.component';

describe('KorisnikUslugeComponent', () => {
  let component: Korisnik_uslugeComponent;
  let fixture: ComponentFixture<Korisnik_uslugeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Korisnik_uslugeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Korisnik_uslugeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
