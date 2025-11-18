import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { tap } from "rxjs";

interface TokenResponse {
    token: string;
}

@Injectable({
    providedIn:"root"

})
export class AuthService {

    private apiUrl = "http://localhost:3213/api/auth"

    constructor(private http: HttpClient) {}

    login(credentials: any): Observable<TokenResponse> {
        const loginUrl = `${this.apiUrl}/login`;

        return this.http.post<TokenResponse>(loginUrl,credentials).pipe(
            tap(response => {
                if (response && response.token) {
                    localStorage.setItem("authToken",response.token);
                }
            })
        );
    }

    logout(): void {
        localStorage.removeItem('authToken');
    }

    isLoggedIn(): boolean {
        return !localStorage.getItem('authToken');
    }


}