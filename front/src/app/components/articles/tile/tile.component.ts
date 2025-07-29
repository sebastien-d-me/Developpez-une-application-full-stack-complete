import { Component, Input } from "@angular/core";


@Component({
    selector: "app-article-tile",
    standalone: true,
    imports: [],
    templateUrl: "./tile.component.html",
    styleUrl: "./tile.component.scss"
})


export class ArticleTileComponent {
    /* Input */
    @Input() title : string = "";
    @Input() date : string = "";
    @Input() author : string = "";
    @Input() text : string = "";
    @Input() id : number = 0;


    /* On Changes */
    public link: string = "";
    ngOnChanges() {
        this.link = `/articles/${this.id}`;
    }
}
