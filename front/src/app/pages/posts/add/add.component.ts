import { Component } from "@angular/core";
import { CommonModule } from "@angular/common";
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from "@angular/forms";
import { RouterModule } from "@angular/router";
import { ButtonModule } from "primeng/button";
import { InputTextModule } from "primeng/inputtext";
import { SelectModule } from "primeng/select";
import { TextareaModule } from "primeng/textarea";
import { PageInformationsComponent } from "../../../components/page-informations/page-informations.component";
import { TopicsService } from "../../../services/topics/topics.service";
import { TopicInterface } from "../../../interfaces/Topic";
import { PostsService } from "../../../services/posts/posts.service";

@Component({
    selector: "app-post-add",
    standalone: true,
    imports: [
        CommonModule, 
        FormsModule,
        ReactiveFormsModule,
        RouterModule,
        ButtonModule,
        InputTextModule,
        SelectModule,
        TextareaModule,
        PageInformationsComponent
    ],
    templateUrl: "./add.component.html",
    styleUrl: "./add.component.scss"
})


export class PostsAddPage {
    /* Call the service */
    constructor(private topicService: TopicsService, private postService : PostsService) {}


    /* Create the FormGroup */
    postForm: FormGroup = new FormGroup({
        topic: new FormControl(""),
        title: new FormControl(""),
        content: new FormControl("")
    });


    /* Load the topics */
    topics: TopicInterface[] = [];
    
    ngOnInit() {
        this.topicService.getTopics().subscribe(data => {
            this.topics = data.topics;
        });
    }


    /* Submit the form */
    showMessage: boolean = false;

    onSubmit() {
        const data = {
            "topic": this.postForm.get("topic")?.value,
            "title": this.postForm.get("title")?.value,
            "content": this.postForm.get("content")?.value,
            "user": 1
        }
        this.postService.publishPost(data).subscribe(event => {
            // vider le formulaire
            this.showMessage = true;
        });
    }
}
