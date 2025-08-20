import { ApplicationConfig, LOCALE_ID, provideZoneChangeDetection } from "@angular/core";
import { provideRouter } from "@angular/router";
import { routes } from "./app.routes";
import { provideAnimationsAsync } from "@angular/platform-browser/animations/async";
import { providePrimeNG } from "primeng/config";
import Aura from "@primeng/themes/aura";
import { HTTP_INTERCEPTORS, provideHttpClient, withInterceptorsFromDi } from "@angular/common/http";
import { JwtInterceptor } from "./interceptors/jwt.interceptor";


export const appConfig: ApplicationConfig = {
    providers: [
        provideZoneChangeDetection({ eventCoalescing: true }), 
        provideRouter(routes),
        { provide: LOCALE_ID, useValue: "fr-FR" },
        provideAnimationsAsync(),
        providePrimeNG({ 
            theme: {
                options: { darkModeSelector: false || "none" },
                preset: Aura
            }
        }),
        provideHttpClient(withInterceptorsFromDi()),
        {
            provide: HTTP_INTERCEPTORS,
            useClass: JwtInterceptor,
            multi: true
        }
    ]
};
