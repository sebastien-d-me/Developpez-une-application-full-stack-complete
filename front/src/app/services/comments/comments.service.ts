import { CommentsInterface, CommentsRequest } from "../../interfaces/Comments";
import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";


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


    /* Comment a post */
    public publishComment(commentsRequest: CommentsRequest): Observable<void> {
        return this.http.post<void>(this.commentsUrl, commentsRequest);
    }
}
