import { Component } from "@angular/core";
import { RouterModule } from "@angular/router";
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from "@angular/forms";
import { ButtonModule } from "primeng/button";
import { InputTextModule } from "primeng/inputtext";
import { PageInformationsComponent } from "../../../components/page-informations/page-informations.component";
import { UserService } from "../../../services/user/user.service";
import { Router } from "@angular/router";


@Component({
    selector: "app-member-login",
    standalone: true,
    imports: [
        RouterModule,
        FormsModule,
        ReactiveFormsModule,
        ButtonModule,
        InputTextModule,
        PageInformationsComponent, 
    ],
    templateUrl: "./login.component.html",
    styleUrl: "./login.component.scss"
})


export class MemberLoginPage {
    /* Call the service */
    constructor(private userService: UserService, private router: Router) {}

    /* Create the FormGroup */
    loginForm: FormGroup = new FormGroup({
        usernameOrMail: new FormControl(""),
        password: new FormControl("")
    });


    /* Submit the form */
    showMessage: boolean = false;

    onSubmit() {
        const data = {
            "usernameOrMail": this.loginForm.get("usernameOrMail")?.value,
            "password": this.loginForm.get("password")?.value,
        }
        this.userService.login(data).subscribe({
            next: (response) => {
                localStorage.setItem("token", response.token);
                const tokenParsed = JSON.parse(atob(response.token.split(".")[1]));
                const tokenExpiration = (tokenParsed.exp).toString();
                localStorage.setItem("token_expiration", tokenExpiration);
                this.router.navigate(["/user/feed"]);
            }
        });
    }
}
