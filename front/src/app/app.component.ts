import { Component } from "@angular/core";
import { CommonModule } from "@angular/common";
import { HeaderComponent } from "./layouts/header/header.component";
import { Router, RouterOutlet } from "@angular/router";
import "@fontsource/poppins";


@Component({
    selector: "app-root",
    standalone: true,
    imports: [CommonModule, HeaderComponent, RouterOutlet],
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
