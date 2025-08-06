import { Component } from "@angular/core";
import { CommonModule } from "@angular/common";
import { RouterLink } from "@angular/router";
import { ButtonModule } from "primeng/button";
import { PostTileComponent } from "../../../components/posts/tile/tile.component";
import { PostsService } from "../../../services/posts/posts.service";
import { PostInterface } from "../../../interfaces/Post";


@Component({
  selector: "app-member-feed",
  standalone: true,
  imports: [CommonModule, RouterLink, ButtonModule, PostTileComponent],
  templateUrl: "./feed.component.html",
  styleUrl: "./feed.component.scss"
})


export class MemberFeedPage {
    /* Call the service */
    constructor(private postsService: PostsService) {}


    /* Load the posts */
    posts: PostInterface[] = [];
    
    ngOnInit() {
        this.postsService.getPosts().subscribe(data => {
            this.posts = data.posts;
        })
    }


    /* Filter by */    
    filterBy(type: string) {
        document.querySelector(".pi-arrow-down")?.classList.remove("hide");
        document.querySelector(".pi-arrow-up")?.classList.remove("hide");
        type === "old" ? document.querySelector(".pi-arrow-down")?.classList.add("hide") : document.querySelector(".pi-arrow-up")?.classList.add("hide");
        this.posts.reverse();
    }
}
