import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { Country } from '../../interfaces/country';
import { GetsService } from '../../services/gets.service';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  countries: Country[];
  registerForm: FormGroup;


  constructor(private formBuilder: FormBuilder, private authService: AuthService, private router: Router, private countryService: GetsService) { 
    this.registerForm = formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      username: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(8)]],
      password2: ['', Validators.required],
      weight: ['', Validators.required],
      height: ['', Validators.required],
      birthDate: ['', Validators.required],
      country: ['', Validators.required]
    });
  }

  ngOnInit() {
    this.countryService.getAllCountries().subscribe(
      (data: Country[]) => {
        this.countries = data;
      },
      (error) => {
        console.error('Error al obtener los países', error);
      }
    );
  }


  register() {
    if (this.registerForm.valid) {
      this.authService.register(this.registerForm.value).subscribe({
        next: (response) => {
          console.log("Registrado correctamente");
          this.router.navigate(['/login']);
        },
        error: (err) => {
          console.log("Algo ha fallado", err);
        },
        complete: () => {
          console.log("Registro completado");
        }
      });
    }
  }


}
