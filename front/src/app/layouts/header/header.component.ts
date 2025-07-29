import { Component} from "@angular/core";
import { CommonModule } from "@angular/common";
import { Router, RouterLink, RouterModule } from "@angular/router";


@Component({
    selector: "app-header",
    standalone: true,
    imports: [CommonModule, RouterLink, RouterModule],
    templateUrl: "./header.component.html",
    styleUrl: "./header.component.scss"
})


export class HeaderComponent {
    /* Manage the header layout */
    public isMemberMenu: boolean = false;
    constructor(private router: Router) {
        this.router.events.subscribe(() => {
            switch(this.router.url) {
                case "/":
                    this.isMemberMenu = false;
                    break;
                case "/member/register":
                    this.isMemberMenu = false;
                    break;
                case "/member/login":
                    this.isMemberMenu = false;
                    break;
                default:
                    this.isMemberMenu = true;
                    break;
            }
        });
    }


    /* Open menu */
    openMenu() {
        document.querySelector(".mobile__pannel")?.classList.remove("hide");
        document.querySelector(".overlay")?.classList.remove("hide");
    }


    /* Close menu */
    hideMenu() {
        if(!document.querySelector(".mobile__pannel")?.classList.contains("hide")) {
            document.querySelector(".mobile__pannel")?.classList.add("hide");
            document.querySelector(".overlay")?.classList.add("hide");
        }
    }
}
