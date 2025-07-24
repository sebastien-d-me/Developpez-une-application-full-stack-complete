import { Component } from '@angular/core';
import { CommentComponent } from "../../../components/comment/comment.component";
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TextareaModule } from 'primeng/textarea';
import { CommonModule } from '@angular/common';


interface Comment {
    author: string;
    date: string;
    text: string;
}



@Component({
  selector: 'app-article',
  standalone: true,
  imports: [CommentComponent, TextareaModule, CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './article.component.html',
  styleUrl: './article.component.scss'
})
export class ArticleComponent {

    commentForm: FormGroup;

    constructor() {
        this.commentForm = new FormGroup({
            content: new FormControl("")
        });
    }

    comments: Comment[] = [
        {
            date: "10-07-2025",
            author: "Sébastien D.",
            text: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Esse, voluptatum? Maxime totam assumenda sunt aliquam!"
        },
        {
            date: "07-07-2025",
            author: "John D.",
            text: "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Tenetur, tempore."
        },
        {
            date: "06-07-2025",
            author: "Sébastien D.",
            text: "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Explicabo recusandae suscipit sint reiciendis dolor facere at, nulla quas repellendus ut."
        },
        {
            date: "01-07-2025",
            author: "Martin A.",
            text: "Lorem ipsum, dolor sit amet consectetur adipisicing elit."
        }
    ];
}
