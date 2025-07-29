import { Component } from "@angular/core";
import { CommonModule } from "@angular/common";
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from "@angular/forms";
import { ButtonModule } from "primeng/button";
import { InputTextModule } from "primeng/inputtext";
import { ThemeTileComponent } from "../../../components/themes/tile/tile.component";


interface Theme {
    title: string;
    text: string;
    isSubscribe: boolean
}


@Component({
    selector: "app-member-profil",
    standalone: true,
    imports: [
        CommonModule, 
        FormsModule,
        ReactiveFormsModule,
        ButtonModule,
        InputTextModule,
        ThemeTileComponent, 
    ],
    templateUrl: "./profil.component.html",
    styleUrl: "./profil.component.scss"
})


export class MemberProfilPage {
    /* Create the FormGroup */
    profilForm: FormGroup = new FormGroup({
        username: new FormControl(""),
        email: new FormControl(""),
        password: new FormControl("")
    });


    /* Load the themes */
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
}
