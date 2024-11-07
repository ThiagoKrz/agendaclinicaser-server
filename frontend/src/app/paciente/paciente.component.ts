import { Component, OnInit } from '@angular/core';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import
 { Paciente } from './paciente';
import { PacienteService } from './paciente.service';

@Component({
  selector: 'app-paciente',
  standalone: true,
  imports: [],
  templateUrl: './paciente.component.html',
  styleUrl: './paciente.component.scss'
})
export class PacienteComponent implements OnInit {
  pacientes = [];
  pacientesFiltrados = [];
  searchTerm: string = '';
  pacientesAtivos: boolean = true;

  constructor(private pacienteService: PacienteService) {}

  ngOnInit(): void {
    this.pacienteService.getPacientes().subscribe((data) => {
      this.pacientes = data;
      this.filtrarPacientes();
    });
  }

  filtrarPacientes(): void {
    this.pacientesFiltrados = this.pacientes.filter(paciente =>
      paciente.nome.toLowerCase().includes(this.searchTerm.toLowerCase()) &&
      (this.pacientesAtivos ? paciente.status === 'Ativo' : true)
    );
  }

  alternarStatus(): void {
    this.pacientesAtivos = !this.pacientesAtivos;
    this.filtrarPacientes();
  }
}
// paciente.service.ts

