import { Component } from '@angular/core';
import { ThemeTileComponent } from '../../components/theme-tile/theme-tile.component';
import { CommonModule } from '@angular/common';

interface Theme {
    title: string;
    text: string;
    isSubscribe: boolean
}


@Component({
  selector: 'app-themes',
  standalone: true,
  imports: [ThemeTileComponent, CommonModule],
  templateUrl: './themes.component.html',
  styleUrl: './themes.component.scss'
})
export class ThemesComponent {
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
