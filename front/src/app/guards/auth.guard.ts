import { Injectable } from "@angular/core";
import { CanActivate, Router } from "@angular/router";


@Injectable({
    providedIn: "root"
})


export class AuthGuard implements CanActivate {
    constructor(private router: Router) {}

    canActivate(): boolean {
        const token = localStorage.getItem("token");
        const tokenExpiration = localStorage.getItem("token_expiration");
        
        if (token && tokenExpiration) {
            const currentDate = Math.floor(Date.now() / 1000);
            const checkExpiration = parseInt(tokenExpiration, 10);

            if(currentDate > checkExpiration) {
                localStorage.removeItem("token");
                localStorage.removeItem("token_expiration");
                this.router.navigate(["user/login"]);
                return false;
            }
            return true;
        } else {
            this.router.navigate(["user/login"]);
            return false;
        }
    }
}
