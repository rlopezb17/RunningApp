import { Component } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { Country } from '../../interfaces/country';
import { GetsService } from '../../services/gets.service';
import { User } from '../../interfaces/user';

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
  submitted = false;


  constructor(private formBuilder: FormBuilder, private authService: AuthService, private router: Router, private countryService: GetsService) { }

  ngOnInit() {

    this.registerForm = this.formBuilder.group({
      firstName: ['', [Validators.required, Validators.minLength(3)]],
      lastName: ['', [Validators.required, Validators.minLength(3)]],
      email: ['', [Validators.required, Validators.email]],
      username: ['', [Validators.required, Validators.minLength(3)]],
      password: ['', [Validators.required, Validators.minLength(8)]],
      password2: ['', [Validators.required]],
      weight: ['', [Validators.required, Validators.min(40), Validators.max(200)]],
      height: ['', [Validators.required, Validators.min(100), Validators.max(230)]],
      birthDate: ['', [Validators.required]],
      country: ['', [Validators.required]]
    }, { validators: this.passwordMatchValidator });

    this.countryService.getAllCountries().subscribe({
      next: (data) =>{
        this.countries = data;
      },
      error: (err) => {
        console.log("Something went wrong", err);
      }
    });
  }

  passwordMatchValidator(control: AbstractControl): { [key: string]: boolean } | null {
    const password = control.get('password');
    const password2 = control.get('password2');
    if (password && password2 && password.value !== password2.value) {
      return { 'mismatch': true };
    }
    return null;
  }

  register() {
    this.submitted = true;

    if(this.registerForm.invalid){
      return;
    }

    const user: User = this.registerForm.value;

    this.authService.register(user).subscribe({
      next: (response) => {
        this.router.navigate(['/login'])
      },
      error: (err) => {
        console.log("Something went wrong ", err)
      },
      complete: () => {
        console.log("Register succesfully!")
      }
    });
  }


}
