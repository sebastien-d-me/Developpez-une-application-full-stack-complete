import { Component } from "@angular/core";
import { PageInformationsComponent } from "../../components/page-informations/page-informations.component";
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from "@angular/forms";
import { InputTextModule } from "primeng/inputtext";
import { ButtonModule } from "primeng/button";
import { RouterModule } from "@angular/router";

@Component({
  selector: "app-register",
  standalone: true,
  imports: [PageInformationsComponent, FormsModule, InputTextModule, ReactiveFormsModule, ButtonModule, RouterModule],
  templateUrl: "./register.component.html",
  styleUrl: "./register.component.scss"
})
export class RegisterComponent {
    registerForm: FormGroup;

    constructor() {
        this.registerForm = new FormGroup({
            username: new FormControl(""),
            email: new FormControl(""),
            password: new FormControl("")
        });
    }
}