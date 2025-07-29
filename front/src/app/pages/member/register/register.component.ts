import { Component } from "@angular/core";
import { RouterModule } from "@angular/router";
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from "@angular/forms";
import { ButtonModule } from "primeng/button";
import { InputTextModule } from "primeng/inputtext";
import { PageInformationsComponent } from "../../../components/page-informations/page-informations.component";


@Component({
    selector: "app-member-register",
    standalone: true,
    imports: [
        RouterModule,
        FormsModule,
        ReactiveFormsModule,
        ButtonModule,
        InputTextModule,
        PageInformationsComponent, 
    ],
    templateUrl: "./register.component.html",
    styleUrl: "./register.component.scss"
})


export class MemberRegisterPage {
    /* Create the FormGroup */
    registerForm: FormGroup = new FormGroup({
        username: new FormControl(""),
        email: new FormControl(""),
        password: new FormControl("")
    });
}