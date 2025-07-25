import { Component, ElementRef, ViewChild } from "@angular/core";
import { ArticleTileComponent } from "../../../components/articles/article-tile/article-tile.component";
import { ButtonModule } from "primeng/button";
import { CommonModule } from "@angular/common";
import { RouterLink } from "@angular/router";


interface Article {
    title: string;
    date: string;
    author: string;
    text: string;
    id: number;
}

@Component({
  selector: "app-dashboard",
  standalone: true,
  imports: [ArticleTileComponent, CommonModule, ButtonModule, RouterLink],
  templateUrl: "./dashboard.component.html",
  styleUrl: "./dashboard.component.scss"
})

export class DashboardComponent {
    articles: Article[] = [
        {
            id: 1,
            title: "Article 1",
            date: "10-07-2025",
            author: "Sébastien D.",
            text: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Esse, voluptatum? Maxime totam assumenda sunt aliquam!"
        },
        {
            id: 2,
            title: "Article 2",
            date: "07-07-2025",
            author: "John D.",
            text: "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Tenetur, tempore."
        },
        {
            id: 3,
            title: "Article 3",
            date: "06-07-2025",
            author: "Sébastien D.",
            text: "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Explicabo recusandae suscipit sint reiciendis dolor facere at, nulla quas repellendus ut."
        },
        {
            id: 4,
            title: "Article 4",
            date: "01-07-2025",
            author: "Martin A.",
            text: "Lorem ipsum, dolor sit amet consectetur adipisicing elit."
        }
    ];

    /* Filter by */
    @ViewChild("arrowDown") arrowDown!: ElementRef;
    @ViewChild("arrowUp") arrowUp!: ElementRef;
    
    filterBy(type: string) {
        this.arrowDown.nativeElement.classList.remove("hide");
        this.arrowUp.nativeElement.classList.remove("hide");
        type === "old" ? this.arrowDown.nativeElement.classList.add("hide") : this.arrowUp.nativeElement.classList.add("hide");
        this.articles.reverse();
    }
}
