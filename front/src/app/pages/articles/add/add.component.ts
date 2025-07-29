import { Component } from "@angular/core";
import { CommonModule } from "@angular/common";
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from "@angular/forms";
import { RouterModule } from "@angular/router";
import { ButtonModule } from "primeng/button";
import { InputTextModule } from "primeng/inputtext";
import { SelectModule } from "primeng/select";
import { TextareaModule } from "primeng/textarea";
import { PageInformationsComponent } from "../../../components/page-informations/page-informations.component";


interface Theme {
    name: string;
    value: string;
}


@Component({
    selector: "app-article-add",
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


export class ArticlesAddPage {
    /* Create the FormGroup */
    articleForm: FormGroup = new FormGroup({
        theme: new FormControl(""),
        title: new FormControl(""),
        content: new FormControl("")
    });


    /* Load the themes */
    themes: Theme[] =  [
        { name: "Option 1", value: "option-1" },
        { name: "Option 2", value: "option-2" },
        { name: "Option 3", value: "option-3" },
    ];
}
