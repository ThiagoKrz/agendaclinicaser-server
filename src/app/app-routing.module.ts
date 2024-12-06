import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PacientesComponent } from './pacientes/pacientes.component'; // Importa o componente Pacientes
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CalendarModule, DateAdapter } from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';
import { AgendaComponent } from './agenda/agenda.component';
import { EventSettingsModel, DayService, WeekService, WorkWeekService, MonthService, AgendaService, ScheduleModule } from '@syncfusion/ej2-angular-schedule';
import { PainelSalasComponent } from './painel-salas/painel-salas.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import { CadastroUsuarioComponent } from './cadastro-usuario/cadastro-usuario.component';

// Define as rotas
const routes: Routes = [
  { path: 'pacientes', component: PacientesComponent },
  { path: 'agenda', component: AgendaComponent }, // Rota para a lista de pacientes
  { path: 'painel-salas', component: PainelSalasComponent },
  { path: 'cadastro-usuario', component: CadastroUsuarioComponent },
  { path: '', redirectTo: '/agenda', pathMatch: 'full' },
  { path: '**', redirectTo: '/agenda' },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    FormsModule,
    BrowserAnimationsModule,
    CalendarModule.forRoot({
      provide: DateAdapter,
      useFactory: adapterFactory,
    }),
    CalendarModule,
    RouterModule,
    ScheduleModule,
  ],
  exports: [RouterModule, FormsModule],
})
export class AppRoutingModule {}
