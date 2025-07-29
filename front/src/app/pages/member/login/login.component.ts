import { Component } from "@angular/core";
import { RouterModule } from "@angular/router";
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from "@angular/forms";
import { ButtonModule } from "primeng/button";
import { InputTextModule } from "primeng/inputtext";
import { PageInformationsComponent } from "../../../components/page-informations/page-informations.component";


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
    /* Create the FormGroup */
    loginForm: FormGroup = new FormGroup({
        username: new FormControl(""),
        password: new FormControl("")
    });
}
