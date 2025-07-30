import { Component } from "@angular/core";
import { CommonModule } from "@angular/common";
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from "@angular/forms";
import { RouterModule, RouterLink } from "@angular/router";
import { TextareaModule } from "primeng/textarea";
import { CommentComponent } from "../../../components/posts/comment/comment.component";


interface Comment {
    author: string;
    text: string;
}


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
        CommentComponent],
    templateUrl: "./view.component.html",
    styleUrl: "./view.component.scss"
})


export class PostsViewPage {
    /* Create the FormGroup */
    public commentForm: FormGroup = new FormGroup({
        text: new FormControl("")
    });


    /* Load the comments */
    public comments: Comment[] = [
        {
            author: "Sébastien D.",
            text: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Esse, voluptatum? Maxime totam assumenda sunt aliquam!"
        },
        {
            author: "John D.",
            text: "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Tenetur, tempore."
        },
        {
            author: "Sébastien D.",
            text: "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Explicabo recusandae suscipit sint reiciendis dolor facere at, nulla quas repellendus ut."
        },
        {
            author: "Martin A.",
            text: "Lorem ipsum, dolor sit amet consectetur adipisicing elit."
        }
    ];
}
