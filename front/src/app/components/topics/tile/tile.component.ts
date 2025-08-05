import { CommonModule } from "@angular/common";
import { Component, EventEmitter, Input, Output } from "@angular/core";
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
    /* Input  & Output */
    @Input() title : string = "";
    @Input() content : string = "";
    @Input() subscribe : boolean = false;
    @Output() unsubscribe = new EventEmitter<void>();


    /* Can unsubscribe check */
    public canUnsubscribe: boolean = false;
    constructor(private router: Router) {
        this.canUnsubscribe = this.router.url === "/user/profil" ? true : false;
    }


    /* Call the unsubscribe click */
    unsubscribeTopic() {
        this.unsubscribe.emit();
    }
}
