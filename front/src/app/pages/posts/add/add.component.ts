import { Component } from "@angular/core";
import { CommonModule } from "@angular/common";
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from "@angular/forms";
import { RouterModule } from "@angular/router";
import { ButtonModule } from "primeng/button";
import { InputTextModule } from "primeng/inputtext";
import { SelectModule } from "primeng/select";
import { TextareaModule } from "primeng/textarea";
import { PageInformationsComponent } from "../../../components/page-informations/page-informations.component";


interface Topic {
    name: string;
    value: string;
}


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
    /* Create the FormGroup */
    postForm: FormGroup = new FormGroup({
        topic: new FormControl(""),
        title: new FormControl(""),
        content: new FormControl("")
    });


    /* Load the topics */
    topics: Topic[] =  [
        { name: "Option 1", value: "option-1" },
        { name: "Option 2", value: "option-2" },
        { name: "Option 3", value: "option-3" },
    ];
}
