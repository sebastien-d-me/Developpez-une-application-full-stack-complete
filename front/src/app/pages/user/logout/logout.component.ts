import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { UserService } from "../../../services/user/user.service";


@Component({
    selector: "app-logout",
    standalone: true,
    imports: [],
    templateUrl: "./logout.component.html",
    styleUrl: "./logout.component.scss"
})


export class MemberLogoutPage {
    /* Call the service */
    constructor(private router: Router, private userService: UserService) {}
    

    /* Logout */
    ngOnInit() {
        this.userService.userLogout();
        this.router.navigate(["/user/login"]);
    }
}
