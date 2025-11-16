import { bootstrapApplication } from '@angular/platform-browser';
import { provideHttpClient } from '@angular/common/http'; 
import { importProvidersFrom } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './app/auth/login/login.component';
import { RegisterComponent } from './app/auth/register/register.component';
import { provideRouter } from '@angular/router';
import { routes } from "./app/app.routes"
import { AppComponent } from './app/app.component';

bootstrapApplication(AppComponent, {
  providers: [
    provideRouter(routes),
    provideHttpClient(), 
    importProvidersFrom(FormsModule) 
  ]
}).catch((err) => console.error(err));
