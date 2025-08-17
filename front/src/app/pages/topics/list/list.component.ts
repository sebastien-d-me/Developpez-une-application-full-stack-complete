import { Component } from "@angular/core";
import { CommonModule } from "@angular/common";
import { TopicTileComponent } from "../../../components/topics/tile/tile.component";
import { TopicsService } from "../../../services/topics/topics.service";
import { TopicInterface } from "../../../interfaces/Topic";


@Component({
    selector: "app-topics-list",
    standalone: true,
    imports: [CommonModule, TopicTileComponent],
    templateUrl: "./list.component.html",
    styleUrl: "./list.component.scss"
})


export class TopicsListPage {
    /* Call the service */
    constructor(private topicsService: TopicsService) {}


    /* Load the topics */
    topics: TopicInterface[] = [];
    
    ngOnInit() {
        this.topicsService.getTopicsForUser().subscribe(data => {
            this.topics = data.topics;
        });
    } 


    /* Subscribe the topic */
    subscribe(topic: TopicInterface) {
        this.topicsService.subscribeTopicForUser(topic.id_topics).subscribe(() => {
            topic.subscribe = true;
        });
    }
}
