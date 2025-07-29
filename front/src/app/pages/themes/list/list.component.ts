import { Component } from "@angular/core";
import { CommonModule } from "@angular/common";
import { ThemeTileComponent } from "../../../components/themes/tile/tile.component";


interface Theme {
    title: string;
    text: string;
    isSubscribe: boolean
}


@Component({
    selector: "app-themes-list",
    standalone: true,
    imports: [CommonModule, ThemeTileComponent],
    templateUrl: "./list.component.html",
    styleUrl: "./list.component.scss"
})


export class ThemesListPage {
    /* Load the themes */
    public themes: Theme[] = [
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
        }
    ];
}
