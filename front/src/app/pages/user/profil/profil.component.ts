import { Component } from "@angular/core";
import { CommonModule } from "@angular/common";
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from "@angular/forms";
import { ButtonModule } from "primeng/button";
import { InputTextModule } from "primeng/inputtext";
import { TopicTileComponent } from "../../../components/topics/tile/tile.component";
import { TopicsService } from "../../../services/topics/topics.service";
import { TopicInterface } from "../../../interfaces/Topic";
import { UserService } from "../../../services/user/user.service";
import { Router, RouterModule } from "@angular/router";
import { MessageService } from "primeng/api";
import { ToastModule } from 'primeng/toast';

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
        ToastModule
    ],
    providers: [MessageService],
    templateUrl: "./profil.component.html",
    styleUrl: "./profil.component.scss"
})


export class MemberProfilPage {
    /* Call the service */
    constructor(private topicService: TopicsService, private userService: UserService, private router: Router, private messageService: MessageService) {}


    /* Create the FormGroup */
    profilForm: FormGroup = new FormGroup({
        username: new FormControl(""),
        email_address: new FormControl(""),
        password: new FormControl("")
    });


    /* Load the topics */
    topics: TopicInterface[] = [];
    
    ngOnInit() {
        this.topicService.getTopicsForUser().subscribe(data => {
            this.topics = data.topics.filter(topic => topic.subscribe === true);
        });
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


    /* Submit the form */
    onSubmit() {
        const data = {
            "username": this.profilForm.get("username")?.value,
            "email_address": this.profilForm.get("email_address")?.value,
            "password": this.profilForm.get("password")?.value,
        }
        this.userService.update(data).subscribe({
            next: () => {
                this.messageService.add({ severity: "success", summary: "Succès", detail: "Modifications effectuées" });
                this.router.navigate(["/user/logout"]);
            },
            error: (err) => {
               this.messageService.add({ severity: "error", summary: "Erreur", detail: `${err.error}` });
            }
        });
    }
}
