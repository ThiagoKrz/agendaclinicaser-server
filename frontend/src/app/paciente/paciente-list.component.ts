import { Component, OnInit } from '@angular/core';
import { Paciente } from './paciente';
import { PacienteService } from './paciente.service';

@Component({
  selector: 'app-paciente-list',  

  templateUrl: './paciente.component.html',
  styleUrls: ['./paciente.component.scss']
})
export class PacienteListComponent implements OnInit  
 {
  pacientes: Paciente[] = [];

  constructor(private pacienteService: PacienteService)  
 { }

  ngOnInit(): void {
    this.pacienteService.getPacientes().subscribe(pacientes => {
      this.pacientes = pacientes;  

    });
  }
}
