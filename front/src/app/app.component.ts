import { Component } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { HeaderComponent } from "./layouts/header/header.component";
import { CommonModule } from '@angular/common';
import "@fontsource/poppins";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HeaderComponent, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
    isHomePage = false;

    constructor(private router: Router) {
        this.router.events.subscribe(() => {
            this.isHomePage = this.router.url === "/";
        });
    }

    hideMenu() {
        if(!document.querySelector(".mobile__pannel")?.classList.contains("hide")) {
            document.querySelector(".mobile__pannel")?.classList.add("hide");
            document.querySelector(".overlay")?.classList.add("hide");
        }
    }
}
