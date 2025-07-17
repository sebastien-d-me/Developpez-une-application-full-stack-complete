import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { ButtonModule } from 'primeng/button';

@Component({
  selector: 'app-theme-tile',
  standalone: true,
  imports: [ButtonModule, CommonModule],
  templateUrl: './theme-tile.component.html',
  styleUrl: './theme-tile.component.scss'
})
export class ThemeTileComponent {
    @Input() title : string = "";
    @Input() text : string = "";
    @Input() isSubscribe : boolean = false;
}
