import { Component, OnInit } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { User } from '../../interfaces/user';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [RouterLink, RouterOutlet],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent implements OnInit{

  id: number;

  constructor(private authService: AuthService) {}

  ngOnInit() {

    this.authService.getAuthenticatedUser().subscribe(datos => {
      this.id = datos;
    });

  }


}
