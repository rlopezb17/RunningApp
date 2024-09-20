import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { GetsService } from '../../../services/gets.service';
import { Country } from '../../../interfaces/country';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from '../../../services/auth.service';
import { User } from '../../../interfaces/user';

@Component({
  selector: 'app-data',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './data.component.html',
  styleUrl: './data.component.css'
})
export class DataComponent implements OnInit{

  dataForm: FormGroup;
  countries: Country[];
  id: number;
  updated: boolean = false;

  constructor(private fb : FormBuilder, private getsService: GetsService, private route: ActivatedRoute, private authService: AuthService) {

    this.dataForm = this.fb.group({
      firstName: ['', [Validators.required, Validators.minLength(3), Validators.pattern('^[a-zA-ZÀ-ÿ\u00f1\u00d1]+( [a-zA-ZÀ-ÿ\u00f1\u00d1]+)*$')]],
      lastName: ['', [Validators.required, Validators.minLength(3), Validators.pattern('^[a-zA-ZÀ-ÿ\u00f1\u00d1]+( [a-zA-ZÀ-ÿ\u00f1\u00d1]+)*$')]],
      email: ['', [Validators.required, Validators.pattern('^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}(\.[a-zA-Z]{2,4})?$')]],
      username: ['', [Validators.required, Validators.minLength(3)]],
      weight: ['', [Validators.required, Validators.min(30), Validators.max(200)]],
      height: ['', [Validators.required, Validators.min(100), Validators.max(230)]],
      birthDate: ['', [Validators.required, this.ageValidator]],
      country: ['', [Validators.required]]
    });
  }


  ngOnInit() {
    
    this.id = +this.route.snapshot.paramMap.get('id')!;
    this.authService.getUserById(this.id).subscribe((user: User) => {
      this.dataForm.patchValue(user);
    });

    this.getsService.getAllCountries().subscribe({
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

  update() {

    if(this.dataForm.valid) {
      this.authService.updateUser(this.id , this.dataForm.value).subscribe(response => {
        this.updated = true;
      });
    }

  }

}
