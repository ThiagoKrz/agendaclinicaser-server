import { Routes } from '@angular/router';
import { PacientesComponent } from './pacientes/pacientes.component';
import { AgendaComponent } from './agenda/agenda.component';
export const routes: Routes = [
  { path: 'pacientes', component: PacientesComponent },
  { path: 'agenda', component: AgendaComponent },

];
