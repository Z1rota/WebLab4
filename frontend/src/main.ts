import { bootstrapApplication } from '@angular/platform-browser';
import { provideHttpClient } from '@angular/common/http'; 
import { importProvidersFrom } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './app/auth/login.component';

bootstrapApplication(LoginComponent, {
  providers: [
   
    provideHttpClient(), 
    importProvidersFrom(FormsModule) 
  ]
}).catch((err) => console.error(err));
