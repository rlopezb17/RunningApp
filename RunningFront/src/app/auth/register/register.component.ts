import { Component } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { Country } from '../../interfaces/country';
import { GetsService } from '../../services/gets.service';
import { User } from '../../interfaces/user';
import { isValidDate } from 'rxjs/internal/util/isDate';

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


  constructor(private formBuilder: FormBuilder, private authService: AuthService, private router: Router, private countryService: GetsService) { 

    this.registerForm = this.formBuilder.group({
      firstName: ['', [Validators.required, Validators.minLength(3), Validators.pattern('^[a-zA-ZÀ-ÿ\u00f1\u00d1]+( [a-zA-ZÀ-ÿ\u00f1\u00d1]+)*$')]],
      lastName: ['', [Validators.required, Validators.minLength(3), Validators.pattern('^[a-zA-ZÀ-ÿ\u00f1\u00d1]+( [a-zA-ZÀ-ÿ\u00f1\u00d1]+)*$')]],
      email: ['', [Validators.required, Validators.pattern('^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}(\.[a-zA-Z]{2,4})?$')]],
      password: ['', [Validators.required, Validators.minLength(6), this.passwordStrengthValidator]],
      password2: ['', [Validators.required]],
      weight: ['', [Validators.required, Validators.min(30), Validators.max(200)]],
      height: ['', [Validators.required, Validators.min(100), Validators.max(230)]],
      birthDate: ['', [Validators.required, this.ageValidator]],
      country: ['', [Validators.required]]
    }, { validators: this.passwordMatchValidator });

  }

  ngOnInit() {

    this.countryService.getAllCountries().subscribe({
      next: (data) =>{
        this.countries = data;
      },
      error: (err) => {
        console.log("Error status: ", err.status);
        console.log("Error message: ", err.message);
        console.log("Full error object: ", err);    
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

  passwordStrengthValidator(control: AbstractControl): { [key: string]: boolean } | null {
    const password = control.value;
    const hasUpperCase = /[A-Z]/.test(password);
    const hasLowerCase = /[a-z]/.test(password);
    const hasNumber = /\d/.test(password);

    if (!hasUpperCase || !hasLowerCase || !hasNumber) {
      return { 'weakPassword': true };
    }
    return null;
  }

  ageValidator(control: AbstractControl): { [key: string]: boolean } | null {
    const birthDate = new Date(control.value);
    const today = new Date();
    let age = today.getFullYear() - birthDate.getFullYear();
    const monthDifference = today.getMonth() - birthDate.getMonth();
    const dayDifference = today.getDate() - birthDate.getDate();
    
    if (monthDifference < 0 || (monthDifference === 0 && dayDifference < 0)) {
      age--;
    }

    return age >= 12 && age <=100 ? null : { 'ageInvalid': true };
  }


  register() {
    this.submitted = true;

    if(this.registerForm.invalid){
      return;
    }

    const user: User = this.registerForm.value;

    this.authService.register(user).subscribe({
      next: (response) => {
        this.router.navigate(['/login']);
      },
      error: (err) => {
        console.log("Something went wrong ", err);
      }
    });
  }


}
