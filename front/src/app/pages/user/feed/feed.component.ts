import { Component } from "@angular/core";
import { CommonModule } from "@angular/common";
import { RouterLink } from "@angular/router";
import { ButtonModule } from "primeng/button";
import { PostTileComponent } from "../../../components/posts/tile/tile.component";
import { PostsService } from "../../../services/posts/posts.service";
import { PostInterface } from "../../../interfaces/Post";
import { TopicsService } from "../../../services/topics/topics.service";


@Component({
    selector: "app-member-feed",
    standalone: true,
    imports: [CommonModule, RouterLink, ButtonModule, PostTileComponent],
    templateUrl: "./feed.component.html",
    styleUrl: "./feed.component.scss"
})


export class MemberFeedPage {
    /* Call the service */
    constructor(private postsService: PostsService, private topicService: TopicsService) {}


    /* Load the posts */
    posts: PostInterface[] = [];
    
    ngOnInit() {
        this.topicService.getTopicsForUser().subscribe(data => {
            const subscribedTopics = data.topics.filter(topic => topic.subscribe === true);
            const topicIds = subscribedTopics.map(topic => topic.id_topics);

            this.postsService.getPostsWhereSubscribed(topicIds).subscribe(data => {
                this.posts = data.posts.sort((a, b) => 
                    new Date(b.updated_at).getTime() - new Date(a.updated_at).getTime()
                );
            });
        });
    }


    /* Filter by */    
    filterBy(type: string) {
        document.querySelector(".pi-arrow-down")?.classList.remove("hide");
        document.querySelector(".pi-arrow-up")?.classList.remove("hide");
        type === "old" ? document.querySelector(".pi-arrow-down")?.classList.add("hide") : document.querySelector(".pi-arrow-up")?.classList.add("hide");
        this.posts.reverse();
    }
}
