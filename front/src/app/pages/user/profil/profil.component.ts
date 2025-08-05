import { Component } from "@angular/core";
import { CommonModule } from "@angular/common";
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from "@angular/forms";
import { ButtonModule } from "primeng/button";
import { InputTextModule } from "primeng/inputtext";
import { TopicTileComponent } from "../../../components/topics/tile/tile.component";
import { TopicsService } from "../../../services/topics/topics.service";
import { TopicInterface } from "../../../interfaces/Topic";


@Component({
    selector: "app-member-profil",
    standalone: true,
    imports: [
        CommonModule, 
        FormsModule,
        ReactiveFormsModule,
        ButtonModule,
        InputTextModule,
        TopicTileComponent, 
    ],
    templateUrl: "./profil.component.html",
    styleUrl: "./profil.component.scss"
})


export class MemberProfilPage {
    /* Call the service */
    constructor(private topicService: TopicsService) {}


    /* Create the FormGroup */
    profilForm: FormGroup = new FormGroup({
        username: new FormControl(""),
        email: new FormControl(""),
        password: new FormControl("")
    });


    /* Load the topics */
    topics: TopicInterface[] = [];
    
    ngOnInit() {
        this.topicService.getTopicsForUser(1).subscribe(data => {
            this.topics = data.topics.filter(topic => topic.subscribe === true);
        });
    } 


    /* Subscribe the topic */
    subscribe(topic: TopicInterface) {
        this.topicService.subscribeTopicForUser(topic.id_topics, 1).subscribe(() => {
            topic.subscribe = true;
        });
    }


    /* Unsubscribe the topic */
    unsubscribe(topic: TopicInterface) {
        this.topicService.unsubscribeTopicForUser(topic.id_topics, 1).subscribe(() => {
            topic.subscribe = false;
        });
    }
}
