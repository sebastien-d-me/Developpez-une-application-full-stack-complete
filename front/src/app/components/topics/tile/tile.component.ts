import { CommonModule } from "@angular/common";
import { Component, Input } from "@angular/core";
import { Router } from "@angular/router";
import { ButtonModule } from "primeng/button";


@Component({
  selector: "app-topic-tile",
  standalone: true,
  imports: [CommonModule, ButtonModule],
  templateUrl: "./tile.component.html",
  styleUrl: "./tile.component.scss"
})


export class TopicTileComponent {
    /* Input */
    @Input() title : string = "";
    @Input() content : string = "";
    @Input() subscribe : boolean = false;


    /* Can unsubscribe check */
    public canUnsubscribe: boolean = false;
    constructor(private router: Router) {
        this.canUnsubscribe = this.router.url === "/user/profil" ? true : false;
    }
}
