import { Component, Input } from "@angular/core";
import { RouterModule } from "@angular/router";

@Component({
  selector: "app-page-informations",
  standalone: true,
  imports: [RouterModule],
  templateUrl: "./page-informations.component.html",
  styleUrl: "./page-informations.component.scss"
})
export class PageInformationsComponent {
    @Input() title: string = "";
    @Input() previousURL: string = "";
}
