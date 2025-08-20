import { Component } from "@angular/core";
import { RouterModule } from "@angular/router";
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from "@angular/forms";
import { ButtonModule } from "primeng/button";
import { InputTextModule } from "primeng/inputtext";
import { PageInformationsComponent } from "../../../components/page-informations/page-informations.component";
import { UserService } from "../../../services/user/user.service";
import { CommonModule } from "@angular/common";
import { MessageService } from "primeng/api";
import { ToastModule } from 'primeng/toast';


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
        CommonModule,
        ToastModule
    ],
    providers: [MessageService],
    templateUrl: "./register.component.html",
    styleUrl: "./register.component.scss"
})


export class MemberRegisterPage {
    /* Call the service */
    constructor(private userService: UserService, private messageService: MessageService) {}

    /* Create the FormGroup */
    registerForm: FormGroup = new FormGroup({
        username: new FormControl(""),
        email: new FormControl(""),
        password: new FormControl("")
    });


    /* Submit the form */
    onSubmit() {
        const data = {
            "username": this.registerForm.get("username")?.value,
            "email_address": this.registerForm.get("email")?.value,
            "password": this.registerForm.get("password")?.value,
        }
        this.userService.register(data).subscribe({
            next: () => {
                this.messageService.add({ severity: "success", summary: "Succès", detail: "Le compte a été créé." });
                this.registerForm.reset();
            },
            error: (err) => {
                this.messageService.add({ severity: "error", summary: "Erreur", detail: `${err.error}` });
            }
        });
    }
}