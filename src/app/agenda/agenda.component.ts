import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-agenda',
  templateUrl: './agenda.component.html',
})
export class AgendaComponent {
  viewDate: Date = new Date();
  events: any[] = []; // Preencha com eventos do backend.

  constructor(private router: Router) {}

  onDayClick(event: any): void {
    const selectedDate = event.date;
    this.router.navigate(['/painel-salas'], { queryParams: { data: selectedDate } });
  }
}
