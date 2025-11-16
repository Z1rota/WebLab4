import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import { CommonModule } from '@angular/common';
import { AbstractControl, FormsModule, ValidationErrors } from '@angular/forms';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';




export function passwordValidator(control: AbstractControl): ValidationErrors | null {
  const value = control.value;
  if (!value) {
    return null
  }
  const hasUpperCase = /[A-Z]/.test(value);
  const hasLowerCase = /[a-z]/.test(value);
  const hasNumeric = /[0-9]/.test(value);
  const passwordValid = hasUpperCase && hasLowerCase && hasNumeric;

  if (!passwordValid) {
    return {passwordStrength: {
      hasUpperCase: !hasUpperCase,
      hasLowerCase: !hasLowerCase,
      hasNumeric: !hasNumeric
    }};
  }
  return null;  
}


@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.css',
})

export class RegisterComponent implements OnInit {

   registerForm!: FormGroup;


  credentials = {
    username: "",
    password: "",
    anotherpass: ""
  }

  isLoading = false;
  errorMessage ='';

   constructor(private fb: FormBuilder,private router: Router) {}


  ngOnInit(): void {

    this.registerForm = this.fb.group({
      
      username: ['', [Validators.required, Validators.minLength(3)]],
      password: ['', [
        Validators.required,
        Validators.minLength(6),
        passwordValidator 
      ]],
      confirmPassword: ['', Validators.required]
    }, {
      
      validators: this.passwordsMatchValidator
    });
  }

   passwordsMatchValidator(form: FormGroup): ValidationErrors | null {
   const password = form.get('password')?.value ?? '';
  const confirmPassword = form.get('confirmPassword')?.value ?? '';

    return password === confirmPassword ? null : { passwordsMismatch: true };
  }


   get username() { return this.registerForm.get('username')!; }
  get password() { return this.registerForm.get('password')!; }
  get confirmPassword() { return this.registerForm.get('confirmPassword')!; }

 onSubmit(): void {
   
    this.registerForm.markAllAsTouched();

    if (this.registerForm.invalid) {
      
      return;
    }

    console.log('Форма отправлена!', this.registerForm.value);
    
  }
  
  
}
