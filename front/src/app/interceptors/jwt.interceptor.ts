import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { UserLoginInterface } from "../interfaces/User";


@Injectable()


export class JwtInterceptor implements HttpInterceptor {
    intercept(req: HttpRequest<UserLoginInterface>, next: HttpHandler): Observable<HttpEvent<UserLoginInterface>> {
        if (req.url.endsWith("/register") || req.url.endsWith("/login")) {
            return next.handle(req);
        }
        
        const token = localStorage.getItem("token");
        if (token) {
            const cloned = req.clone({
                setHeaders: {
                    Authorization: `Bearer ${token}`
                }
            });
            return next.handle(cloned);
        }

        return next.handle(req);
    }
}