import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EdicaoSalaDialogComponent } from './edicao-sala-dialog.component';

describe('EdicaoSalaDialogComponent', () => {
  let component: EdicaoSalaDialogComponent;
  let fixture: ComponentFixture<EdicaoSalaDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EdicaoSalaDialogComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EdicaoSalaDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
