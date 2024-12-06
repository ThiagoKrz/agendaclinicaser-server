import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-painel-salas',
  templateUrl: './painel-salas.component.html',
})

export class PainelDeSalasComponent {
  salas: any[] = []; // Dados das salas
  horarios: any[] = []; // Lista de horários

  constructor(private dialog: MatDialog) {}

  abrirEdicaoSala(sala: any, horario: any): void {
    const dialogRef = this.dialog.open(EdicaoSalaDialogComponent, {
      width: '400px',
      data: {
        salaAtual: sala.id,
        salasDisponiveis: this.salas
      }
    });

    dialogRef.afterClosed().subscribe((novaSalaId) => {
      if (novaSalaId) {
        this.atualizarAgendamento(sala, horario, novaSalaId);
      }
    });
  }

  atualizarAgendamento(sala: any, horario: any, novaSalaId: string): void {
    // Enviar os dados atualizados ao backend para salvar as alterações
    console.log(`Agendamento atualizado: ${horario} -> Nova Sala ID: ${novaSalaId}`);
  }

  getClassForSala(sala: any, horario: any): string {
    // Lógica para definir as classes CSS para cada célula
    return 'sala-disponivel'; // Exemplo
  }

  getDetalhesAgendamento(sala: any, horario: any): string {
    // Retorna detalhes sobre o agendamento, se houver
    return `Supervisor: ${sala.supervisor}`;
  }
}
