import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PainelSalasComponent } from './painel-salas.component';

describe('PainelSalasComponent', () => {
  let component: PainelSalasComponent;
  let fixture: ComponentFixture<PainelSalasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PainelSalasComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PainelSalasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
