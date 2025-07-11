import { Component } from '@angular/core';
import { ArticleTileComponent } from "../../components/article-tile/article-tile.component";
import { ButtonModule } from "primeng/button";
import { CommonModule } from '@angular/common';

interface Article {
  title: string;
  date: string;
  author: string;
  text: string;
}

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [ArticleTileComponent, CommonModule, ButtonModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {
    articles: Article[] = [
        {
            title: "Article 1",
            date: "10-07-2025",
            author: "Sébastien D.",
            text: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Esse, voluptatum? Maxime totam assumenda sunt aliquam!"
        },
        {
            title: "Article 2",
            date: "07-07-2025",
            author: "John D.",
            text: "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Tenetur, tempore."
        },
        {
            title: "Article 3",
            date: "06-07-2025",
            author: "Sébastien D.",
            text: "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Explicabo recusandae suscipit sint reiciendis dolor facere at, nulla quas repellendus ut."
        },
        {
            title: "Article 4",
            date: "01-07-2025",
            author: "Martin A.",
            text: "Lorem ipsum, dolor sit amet consectetur adipisicing elit."
        }
    ];

    /* Filter by */
    filterBy(type: string) {
        document.querySelector(".pi-arrow-down")?.classList.remove("hide");
        document.querySelector(".pi-arrow-up")?.classList.remove("hide");
        if(type === "old") {
            document.querySelector(".pi-arrow-down")?.classList.add("hide");
        } else {
            document.querySelector(".pi-arrow-up")?.classList.add("hide");
        }
    }
}
