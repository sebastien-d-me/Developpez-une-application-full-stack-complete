import { ApplicationConfig, LOCALE_ID, provideZoneChangeDetection } from "@angular/core";
import { provideRouter } from "@angular/router";
import { provideAnimationsAsync } from "@angular/platform-browser/animations/async";
import { HTTP_INTERCEPTORS, provideHttpClient } from "@angular/common/http";
import { routes } from "./app.routes";
import { providePrimeNG } from "primeng/config";
import Aura from "@primeng/themes/aura";
import { JwtInterceptor } from "./interceptors/jwt.interceptor";


export const appConfig: ApplicationConfig = {
    providers: [
        { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
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
        provideHttpClient()
    ]
};
