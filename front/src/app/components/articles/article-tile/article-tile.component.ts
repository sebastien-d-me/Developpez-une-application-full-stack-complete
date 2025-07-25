import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-article-tile',
  standalone: true,
  imports: [],
  templateUrl: './article-tile.component.html',
  styleUrl: './article-tile.component.scss'
})
export class ArticleTileComponent {
    @Input() title : string = "";
    @Input() date : string = "";
    @Input() author : string = "";
    @Input() text : string = "";
    @Input() id : number = 0;

    link: string = "";

    ngOnChanges() {
        this.link = `/articles/${this.id}`;
    }
}
