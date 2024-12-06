import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { MatCardModule } from '@angular/material/card';

interface Paciente {
  id: number;
  nome: string;
  endereco: string;
  telefone: string;
  status: string;
}

@Component({
  selector: 'app-pacientes',
  templateUrl: './pacientes.component.html',
  styleUrls: ['./pacientes.component.scss'],
})
export class PacientesComponent implements OnInit {
  displayedColumns: string[] = ['id', 'nome', 'endereco', 'telefone', 'status'];
  dataSource = new MatTableDataSource<any>([]);

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.loadPacientes();
  }

  loadPacientes(): void {
    this.http.get('/api/pacientes').subscribe((data: any[]) => {
      this.dataSource.data = data;
    });
  }

  applyFilter(event: Event): void {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}
