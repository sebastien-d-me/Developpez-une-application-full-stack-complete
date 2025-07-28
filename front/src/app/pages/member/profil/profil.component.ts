import { Component } from '@angular/core';
import { ThemeTileComponent } from "../../../components/themes/tile/tile.component";
import { CommonModule } from '@angular/common';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from "@angular/forms";
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from "primeng/inputtext";


interface Theme {
    title: string;
    text: string;
    isSubscribe: boolean
}


@Component({
  selector: 'app-member-profil',
  standalone: true,
  imports: [ThemeTileComponent, CommonModule, FormsModule, InputTextModule, ReactiveFormsModule, ButtonModule],
  templateUrl: './profil.component.html',
  styleUrl: './profil.component.scss'
})
export class MemberProfilPage {
    profilForm: FormGroup;

    themes: Theme[] = [
        {
            title: "Thème 1",
            text: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Esse, voluptatum? Maxime totam assumenda sunt aliquam!",
            isSubscribe: false,
        },
        {
            title: "Thème 2",
            text: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Esse, voluptatum? Maxime totam assumenda sunt aliquam!",
            isSubscribe: false,
        },
        {
            title: "Thème 3",
            text: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Esse, voluptatum? Maxime totam assumenda sunt aliquam!",
            isSubscribe: true,
        },
        {
            title: "Thème 4",
            text: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Esse, voluptatum? Maxime totam assumenda sunt aliquam!",
            isSubscribe: false,
        },
    ];

        constructor() {
            this.profilForm = new FormGroup({
                username: new FormControl(""),
                email: new FormControl(""),
                password: new FormControl("")
            });
        }
}
