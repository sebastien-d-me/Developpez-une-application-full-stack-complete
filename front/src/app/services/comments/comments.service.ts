import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { CommentsInterface } from "../../interfaces/Comments";

interface CommentsResponse {
    comments: CommentsInterface[];
}


@Injectable({
    providedIn: "root"
})


export class CommentsService {
    private commentsUrl: string;


    /* Get the API URL */
    constructor(private http: HttpClient) {
        this.commentsUrl = "/api/comments";
    }


    /* Get all the comments from a specific post */
    public getCommentsOfPost(postId: string|null): Observable<CommentsResponse> {
        return this.http.get<CommentsResponse>(`${this.commentsUrl}/${postId}`);
    }
}
