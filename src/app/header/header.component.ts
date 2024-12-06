import { Component } from '@angular/core';
import { faCalendarAlt, faUser, faUserShield, faUsers, faClipboardList, faCog, faSignOutAlt } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [FontAwesomeModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {

    faCalendarAlt = faCalendarAlt;
    faUser = faUser;
    faUserShield = faUserShield;
    faUsers = faUsers;
    faClipboardList = faClipboardList;
    faCog = faCog;
    faSignOutAlt = faSignOutAlt;

}
export class NavbarComponent {
  constructor(private router: Router) {}

  acessarPerfil(): void {
    this.router.navigate(['/perfil']); // Redireciona para a página de perfil
  }

  abrirCadastro(): void {
    this.router.navigate(['/cadastro-usuario']); // Redireciona para o formulário de cadastro
  }

  logout(): void {
    // Lógica de logout (limpar token, redirecionar para login, etc.)
    this.router.navigate(['/login']);
  }
}
