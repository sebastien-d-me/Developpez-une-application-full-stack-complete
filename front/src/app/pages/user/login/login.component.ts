import { Component } from "@angular/core";
import { RouterModule } from "@angular/router";
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from "@angular/forms";
import { ButtonModule } from "primeng/button";
import { InputTextModule } from "primeng/inputtext";
import { PageInformationsComponent } from "../../../components/page-informations/page-informations.component";
import { UserService } from "../../../services/user/user.service";


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
    constructor(private userService: UserService) {}

    /* Create the FormGroup */
    loginForm: FormGroup = new FormGroup({
        username: new FormControl(""),
        password: new FormControl("")
    });


    /* Submit the form */
    showMessage: boolean = false;

    onSubmit() {
        const data = {
            "username": this.loginForm.get("topic")?.value,
            "password": this.loginForm.get("content")?.value,
        }
        this.userService.register(data).subscribe(event => {
            // vider le formulaire
            this.showMessage = true;
        });
    }
}
