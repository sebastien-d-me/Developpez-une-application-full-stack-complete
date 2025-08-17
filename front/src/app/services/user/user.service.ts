import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Router } from "@angular/router";
import { UserInterface } from "../../interfaces/User";


@Injectable({
    providedIn: "root"
})


export class UserService {
    private userUrl: string;


    /* Get the API URL */
    constructor(private http: HttpClient) {
        this.userUrl = "/api/users";
    }


    /* Register */
    public register(user: any): Observable<any> {
        return this.http.post<any>(`${this.userUrl}/register`, user);
    }


    /* Login */
    public login(user: any): Observable<any> {
        return this.http.post<any>(`${this.userUrl}/login`, user);
    }


    /* Logout */
    public logout(): void {
        localStorage.removeItem("token");
    }


    /* Details */
    public userDetails(): Observable<any> {
        return this.http.get<UserInterface>(`${this.userUrl}/details`);
    }
}
