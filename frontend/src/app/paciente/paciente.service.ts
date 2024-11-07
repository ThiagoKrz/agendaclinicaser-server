import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import  
 { Paciente } from './paciente';

@Injectable({
  providedIn: 'root'
})
export class PacienteService {
  private: any  
 apiUrl = 'http://localhost:8080/pacientes'; // Substitua pela URL da sua API

  constructor(private http: HttpClient) { }

  getPacientes(): Observable<Paciente[]> {
    return this.http.get<Paciente[]>(this.apiUrl);
  }
}
