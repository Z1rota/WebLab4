import {Component} from '@angular/core';
import {Router} from "@angular/router";
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../auth.service';
import { RouterModule } from '@angular/router';

@Component({
    selector: "app-login",
    standalone: true,
    imports: [CommonModule, FormsModule, RouterModule],
    templateUrl: "./login.component.html",
    styleUrls: ['./login.component.css']

})
export class LoginComponent {
    credentials = {
        username: "",
        password: ""
    };

    errorMessage="";
    isLoading = false;

     constructor(private router: Router, private authService: AuthService) {}


    onSubmit(): void {
    
    if (!this.credentials.username || !this.credentials.password) {
      this.errorMessage = 'Пожалуйста, введите логин и пароль.';
      return;
    }

    this.isLoading = true;
    this.errorMessage = '';

    this.authService.login(this.credentials).subscribe({

        next: (response) => {
            this.router.navigate(["/graph"])
        },

        error: (err) => {
            this.errorMessage = "Неверный логин или пароль. Попробуйте снова"
            this.isLoading = false;
        },

        complete: () => {
            this.isLoading = false;
        }
    });

   
  }

  onRegister(): void {
      this.router.navigate(['/register']);
    }


}