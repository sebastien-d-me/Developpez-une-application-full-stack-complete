import { Component } from "@angular/core";
import { CommonModule } from "@angular/common";
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from "@angular/forms";
import { ButtonModule } from "primeng/button";
import { InputTextModule } from "primeng/inputtext";
import { TopicTileComponent } from "../../../components/topics/tile/tile.component";
import { TopicsService } from "../../../services/topics/topics.service";
import { TopicInterface } from "../../../interfaces/Topic";
import { UserService } from "../../../services/user/user.service";


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
    constructor(private topicService: TopicsService, private userService: UserService) {}


    /* Create the FormGroup */
    profilForm: FormGroup = new FormGroup({
        username: new FormControl(""),
        email: new FormControl(""),
        password: new FormControl("")
    });


    /* Load the topics */
    topics: TopicInterface[] = [];
    
    ngOnInit() {
        this.topicService.getTopicsForUser().subscribe(data => {
            this.topics = data.topics.filter(topic => topic.subscribe === true);
        });

        this.userService.userDetails().subscribe(user => {
            this.profilForm.patchValue({
                username: user.username,
                email: user.email_address
            })
        })
    } 


    /* Subscribe the topic */
    subscribe(topic: TopicInterface) {
        this.topicService.subscribeTopicForUser(topic.id_topics).subscribe(() => {
            topic.subscribe = true;
        });
    }


    /* Unsubscribe the topic */
    unsubscribe(topic: TopicInterface) {
        this.topicService.unsubscribeTopicForUser(topic.id_topics).subscribe(() => {
            topic.subscribe = false;
        });
    }
}
