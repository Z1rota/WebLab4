import {Component} from '@angular/core';
import {Router} from "@angular/router";
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
    selector: "app-login",
    standalone: true,
    imports: [CommonModule, FormsModule],
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

     constructor(private router: Router) {}


  onSubmit(): void {
    // Если форма не заполнена, ничего не делаем
    if (!this.credentials.username || !this.credentials.password) {
      this.errorMessage = 'Пожалуйста, введите логин и пароль.';
      return;
    }

    this.isLoading = true;
    this.errorMessage = '';

    console.log('Отправка данных на сервер:', this.credentials);

    // ЗДЕСЬ БУДЕТ ВЫЗОВ СЕРВИСА АУТЕНТИФИКАЦИИ
    // this.authService.login(this.credentials).subscribe({
    //   next: (response) => {
    //     // Успешный вход
    //     console.log('Успешный вход!', response);
    //     // Перенаправляем на главную страницу приложения
    //     this.router.navigate(['/dashboard']);
    //   },
    //   error: (err) => {
    //     // Ошибка входа
    //     console.error('Ошибка входа:', err);
    //     this.errorMessage = 'Неверный логин или пароль. Попробуйте снова.';
    //     this.isLoading = false;
    //   },
    //   complete: () => {
    //     this.isLoading = false;
    //   }
    // });

    // Имитация задержки ответа от сервера
    setTimeout(() => {
        if(this.credentials.username === "admin" && this.credentials.password === "admin") {
            console.log('Успешный вход (симуляция)!');
            this.router.navigate(['/dashboard']); // <-- Адрес защищенной страницы
        } else {
            this.errorMessage = 'Неверный логин или пароль (симуляция).';
        }
        this.isLoading = false;
    }, 1500);
  }




}