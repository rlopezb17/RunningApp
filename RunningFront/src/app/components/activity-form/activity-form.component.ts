import { Component } from '@angular/core';
import { ActivityComponent } from "../activity/activity.component";
import { NavbarComponent } from "../navbar/navbar.component";

@Component({
  selector: 'app-activity-form',
  standalone: true,
  imports: [ActivityComponent, NavbarComponent],
  templateUrl: './activity-form.component.html',
  styleUrl: './activity-form.component.css'
})
export class ActivityFormComponent {

}
