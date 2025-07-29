import { Component } from "@angular/core";
import { CommonModule } from "@angular/common";
import { Router, RouterOutlet } from "@angular/router";
import { HeaderComponent } from "./layouts/header/header.component";
import "@fontsource/poppins";


@Component({
    selector: "app-root",
    standalone: true,
    imports: [CommonModule, RouterOutlet, HeaderComponent],
    templateUrl: "./app.component.html",
    styleUrl: "./app.component.scss"
})


export class AppComponent {
    /* Check the URL */ 
    public isHomePage: boolean = false;
    constructor(private router: Router) {
        this.router.events.subscribe(() => {
            this.isHomePage = this.router.url === "/" ? true : false;;
        });
    }


    /* Hide menu */
    hideMenu() {
        if(!document.querySelector(".mobile__pannel")?.classList.contains("hide")) {
            document.querySelector(".mobile__pannel")?.classList.add("hide")
            document.querySelector(".overlay")?.classList.add("hide");
        }
    }
}
