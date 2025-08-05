import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { PostInterface } from "../../interfaces/Post";


interface PostsResponse {
    posts: PostInterface[];
}


@Injectable({
    providedIn: "root"
})


export class PostsService {
    private postsUrl: string;


    /* Get the API URL */
    constructor(private http: HttpClient) {
        this.postsUrl = "/api/posts";
    }


    /* Get all the posts */
    public getPosts(): Observable<PostsResponse> {
        return this.http.get<PostsResponse>(this.postsUrl);
    }
}
