import { Component } from "@angular/core";
import { CommonModule } from "@angular/common";
import { RouterLink } from "@angular/router";
import { ButtonModule } from "primeng/button";
import { PostTileComponent } from "../../../components/posts/tile/tile.component";


interface Post {
    id: number;
    title: string;
    date: string;
    author: string;
    text: string;
}


@Component({
  selector: "app-member-feed",
  standalone: true,
  imports: [CommonModule, RouterLink, ButtonModule, PostTileComponent],
  templateUrl: "./feed.component.html",
  styleUrl: "./feed.component.scss"
})


export class MemberFeedPage {
    /* Load the posts */
    public posts: Post[] = [
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
    filterBy(type: string) {
        document.querySelector(".pi-arrow-down")?.classList.remove("hide");
        document.querySelector(".pi-arrow-up")?.classList.remove("hide");
        type === "old" ? document.querySelector(".pi-arrow-down")?.classList.add("hide") : document.querySelector(".pi-arrow-up")?.classList.add("hide");
        this.posts.reverse();
    }
}
