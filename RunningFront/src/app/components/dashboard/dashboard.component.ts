import { Component } from '@angular/core';
import { NavbarComponent } from '../navbar/navbar.component';
import { ActivityComponent } from "../activity/activity.component";

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [NavbarComponent, ActivityComponent],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {

}
