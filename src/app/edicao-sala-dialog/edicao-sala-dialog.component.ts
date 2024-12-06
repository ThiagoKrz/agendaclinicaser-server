import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-edicao-sala-dialog',
  templateUrl: './edicao-sala-dialog.component.html',
  styleUrls: ['./edicao-sala-dialog.component.css']
})
export class EdicaoSalaDialogComponent {
  formEdicao: FormGroup;
  todasSalas: any[] = []; // Popule com as salas disponíveis no sistema

  constructor(
    public dialogRef: MatDialogRef<EdicaoSalaDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private fb: FormBuilder
  ) {
    this.formEdicao = this.fb.group({
      novaSala: [data.salaAtual]
    });

    // Simula a lista de salas disponíveis
    this.todasSalas = data.salasDisponiveis;
  }

  confirmarAlteracao(): void {
    this.dialogRef.close(this.formEdicao.value.novaSala); // Retorna a nova sala selecionada
  }
}
