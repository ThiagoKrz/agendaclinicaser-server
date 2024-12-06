import { Component } from '@angular/core';
import { faCalendarAlt, faUser, faUserShield, faUsers, faClipboardList, faCog, faSignOutAlt } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

@Component({
  selector: 'app-side-nav',
  standalone: true,
  imports: [FontAwesomeModule],
  templateUrl: './side-nav.component.html',
  styleUrl: './side-nav.component.scss'
})
export class SideNavComponent {
  faCalendarAlt = faCalendarAlt;
  faUser = faUser;
  faUserShield = faUserShield;
  faUsers = faUsers;
  faClipboardList = faClipboardList;
  faCog = faCog;
  faSignOutAlt = faSignOutAlt;
}
