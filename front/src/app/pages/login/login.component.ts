import { Component } from '@angular/core';
import { PageInformationsComponent } from "../../components/page-informations/page-informations.component";
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from "@angular/forms";
import { InputTextModule } from "primeng/inputtext";
import { ButtonModule } from "primeng/button";
import { RouterModule } from "@angular/router";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [PageInformationsComponent, FormsModule, InputTextModule, ReactiveFormsModule, ButtonModule, RouterModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
    loginForm: FormGroup;

    constructor() {
        this.loginForm = new FormGroup({
            username: new FormControl(""),
            password: new FormControl("")
        });
    }
}
