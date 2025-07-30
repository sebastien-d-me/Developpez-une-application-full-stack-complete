import { Component } from "@angular/core";
import { CommonModule } from "@angular/common";
import { TopicTileComponent } from "../../../components/topics/tile/tile.component";


interface Topic {
    title: string;
    text: string;
    isSubscribe: boolean
}


@Component({
    selector: "app-topics-list",
    standalone: true,
    imports: [CommonModule, TopicTileComponent],
    templateUrl: "./list.component.html",
    styleUrl: "./list.component.scss"
})


export class TopicsListPage {
    /* Load the topics */
    public topics: Topic[] = [
        {
            title: "Thème 1",
            text: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Esse, voluptatum? Maxime totam assumenda sunt aliquam!",
            isSubscribe: false,
        },
        {
            title: "Thème 2",
            text: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Esse, voluptatum? Maxime totam assumenda sunt aliquam!",
            isSubscribe: false,
        },
        {
            title: "Thème 3",
            text: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Esse, voluptatum? Maxime totam assumenda sunt aliquam!",
            isSubscribe: true,
        },
        {
            title: "Thème 4",
            text: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Esse, voluptatum? Maxime totam assumenda sunt aliquam!",
            isSubscribe: false,
        }
    ];
}
