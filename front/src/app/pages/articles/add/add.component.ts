import { Component } from '@angular/core';
import { PageInformationsComponent } from "../../../components/page-informations/page-informations.component";
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from "@angular/forms";
import { InputTextModule } from "primeng/inputtext";
import { ButtonModule } from "primeng/button";
import { RouterModule } from "@angular/router";
import { CommonModule } from '@angular/common';
import { SelectModule } from 'primeng/select';
import { TextareaModule } from 'primeng/textarea';


interface Theme {
    name: string;
    value: string;
}


@Component({
  selector: 'app-article-add',
  standalone: true,
  imports: [PageInformationsComponent, CommonModule, FormsModule, InputTextModule, ReactiveFormsModule, ButtonModule, RouterModule, SelectModule, TextareaModule],
  templateUrl: './add.component.html',
  styleUrl: './add.component.scss'
})
export class ArticlesAddPage {
    articleForm: FormGroup;

    constructor() {
        this.articleForm = new FormGroup({
            theme: new FormControl(""),
            title: new FormControl(""),
            content: new FormControl("")
        });
    }

    themes: Theme[] | undefined;

    ngOnInit() {
        this.themes = [
            {
                name: "Option 1",
                value: "option-1",
            },
            {
                name: "Option 2",
                value: "option-2",
            },
            {
                name: "Option 3",
                value: "option-3",
            },
        ];
    }
}
