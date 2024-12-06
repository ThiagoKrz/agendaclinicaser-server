import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from "./header/header.component";
import { FaIconLibrary } from '@fortawesome/angular-fontawesome';
import { SideNavComponent } from "./side-nav/side-nav.component";
import { faCalendarAlt, faUser, faUserShield, faUsers, faClipboardList, faCog, faSignOutAlt } from '@fortawesome/free-solid-svg-icons';
import { EventSettingsModel, DayService, WeekService, WorkWeekService, MonthService, AgendaService, MonthAgendaService, TimelineViewsService, TimelineMonthService } from '@syncfusion/ej2-angular-schedule';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HeaderComponent, SideNavComponent, FontAwesomeModule],
  templateUrl: './app.component.html',
  template: `
    <nav>
      <a routerLink="/pacientes">Lista de Pacientes</a>
      <a routerLink="/agenda">Agenda</a>
    </nav>
    <router-outlet></router-outlet>
  `,
    styleUrls: ['./app.component.scss'],

})
export class AppComponent {
  title = 'frontend';
}
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

