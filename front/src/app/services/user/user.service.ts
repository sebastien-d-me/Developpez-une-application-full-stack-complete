import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { UserInterface, UserLoginInterface, UserRegisterInterface, UserDetailsInterface, UserLoginResponseInterface } from "../../interfaces/User";


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
    public userRegister(user: UserRegisterInterface): Observable<void> {
        return this.http.post<void>(`${this.userUrl}/register`, user);
    }


    /* Login */
    public userLogin(user: UserLoginInterface): Observable<UserLoginResponseInterface> {
        return this.http.post<UserLoginResponseInterface>(`${this.userUrl}/login`, user);
    }


    /* Logout */
    public userLogout(): void {
        localStorage.removeItem("token");
    }


    /* Details (GET) */
    public userGetDetails(): Observable<UserInterface> {
        return this.http.get<UserInterface>(`${this.userUrl}/details`);
    }


    /* Details (SET) */
    public userSetDetails(data: UserDetailsInterface): Observable<void> {
        return this.http.post<void>(`${this.userUrl}/details`, data);
    }
}
