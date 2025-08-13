import { Component } from "@angular/core";
import { CommonModule, DatePipe } from "@angular/common";
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from "@angular/forms";
import { RouterModule, RouterLink, ActivatedRoute } from "@angular/router";
import { TextareaModule } from "primeng/textarea";
import { CommentComponent } from "../../../components/posts/comment/comment.component";
import { PostsService } from "../../../services/posts/posts.service";
import { PostInterface } from "../../../interfaces/Post";
import { CommentsInterface } from "../../../interfaces/Comments";
import { CommentsRequest } from "../../../interfaces/CommentsRequest";
import { CommentsService } from "../../../services/comments/comments.service";


@Component({
    selector: "app-post-view",
    standalone: true,
    imports: [
        CommonModule,
        FormsModule,
        ReactiveFormsModule,
        RouterModule,
        RouterLink,
        TextareaModule,
        CommentComponent,
        DatePipe
    ],
    templateUrl: "./view.component.html",
    styleUrl: "./view.component.scss"
})


export class PostsViewPage {
    idPost: string | null = null;

    /* Call the service */
    constructor(
        private route: ActivatedRoute, 
        private postService: PostsService,
        private commentsService: CommentsService    
    ) {}


    /* Create the FormGroup */
    commentForm: FormGroup = new FormGroup({
        content: new FormControl("")
    });


    /* Load the comments */
    comments: CommentsInterface[] = [];

    /* Load the post */   
    post!: PostInterface;
    
    ngOnInit() {
        this.idPost = this.route.snapshot.paramMap.get("id");
        this.postService.getPost(this.idPost).subscribe(data => {
            this.post = data;
        });

        this.commentsService.getCommentsOfPost(this.idPost).subscribe(data => {
            this.comments = data.comments;
        });
    } 

    /* Submit the form */
    showMessage: boolean = false;

    onSubmit() {
        const data = {
            "postId": Number(this.idPost),
            "content": this.commentForm.get("content")?.value,
            "user": 1
        }
        this.commentsService.publishComment(data).subscribe(event => {
            // vider le formulaire
            this.showMessage = true;
        });
    }
}
