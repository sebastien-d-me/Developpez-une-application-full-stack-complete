import { CommonModule } from "@angular/common";
import { Component, Input } from "@angular/core";
import { Router } from "@angular/router";
import { ButtonModule } from "primeng/button";


@Component({
  selector: "app-theme-tile",
  standalone: true,
  imports: [CommonModule, ButtonModule],
  templateUrl: "./tile.component.html",
  styleUrl: "./tile.component.scss"
})


export class ThemeTileComponent {
    /* Input */
    @Input() title : string = "";
    @Input() text : string = "";
    @Input() isSubscribe : boolean = false;


    /* Can unsubscribe check */
    public canUnsubscribe: boolean = false;
    constructor(private router: Router) {
        this.canUnsubscribe = this.router.url === "/member/profil" ? true : false;
    }
}
