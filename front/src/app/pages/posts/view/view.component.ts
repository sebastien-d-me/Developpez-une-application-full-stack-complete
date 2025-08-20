import { Component } from "@angular/core";
import { CommonModule, DatePipe } from "@angular/common";
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from "@angular/forms";
import { RouterModule, RouterLink, ActivatedRoute } from "@angular/router";
import { TextareaModule } from "primeng/textarea";
import { CommentComponent } from "../../../components/posts/comment/comment.component";
import { PostsService } from "../../../services/posts/posts.service";
import { PostInterface } from "../../../interfaces/Post";
import { CommentsInterface } from "../../../interfaces/Comments";
import { CommentsService } from "../../../services/comments/comments.service";
import { MessageService } from "primeng/api";
import { ToastModule } from 'primeng/toast';


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
        DatePipe,
        ToastModule
    ],
    providers: [MessageService],
    templateUrl: "./view.component.html",
    styleUrl: "./view.component.scss"
})


export class PostsViewPage {
    idPost: string | null = null;

    
    /* Call the service */
    constructor(
        private route: ActivatedRoute, 
        private postService: PostsService,
        private commentsService: CommentsService, 
        private messageService: MessageService
    ) {}


    /* Create the FormGroup */
    commentForm: FormGroup = new FormGroup({
        content: new FormControl("")
    });


    /* Load the comments */
    comments: CommentsInterface[] = [];
    loadComments() {
        this.commentsService.getCommentsOfPost(this.idPost).subscribe(data => {
            this.comments = data.comments.sort((a, b) => 
                new Date(b.updated_at).getTime() - new Date(a.updated_at).getTime()
            );
        });
    }


    /* Load the post */   
    post!: PostInterface;
    ngOnInit() {
        this.idPost = this.route.snapshot.paramMap.get("id");
        this.postService.getPost(this.idPost).subscribe(data => {
            this.post = data;
        });

        /* Load comments of post initial */
        this.commentsService.getCommentsOfPost(this.idPost).subscribe(data => {
            this.comments = data.comments.sort((a, b) => 
                new Date(b.updated_at).getTime() - new Date(a.updated_at).getTime()
            );
        });
    } 


    /* Submit the form */
    onSubmit() {
        const data = {
            "postId": Number(this.idPost),
            "content": this.commentForm.get("content")?.value
        }
        this.commentsService.publishComment(data).subscribe({
            next: () => {
                this.messageService.add({ severity: "success", summary: "Succès", detail: "Le commentaire a été créé." });
                this.loadComments();
                this.commentForm.reset();
            },
            error: (err) => {
                this.messageService.add({ severity: "error", summary: "Erreur", detail: `${err.error}` });
            }
        });
    }
}
