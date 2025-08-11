import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { PostInterface } from "../../interfaces/Post";
import { PostsRequest } from "../../interfaces/PostsRequest";

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


    /* Get a specific post */
    public getPost(postId: string|null): Observable<PostInterface> {
        return this.http.get<PostInterface>(`${this.postsUrl}/${postId}`);
    }


    /* Publish a post */
    public publishPost(postRequest: PostsRequest): Observable<void> {
        return this.http.post<void>(this.postsUrl, postRequest);
    }

    /* Get all post where user is subscribed */
    public getPostsWhereSubscribed(topicIds: number[]): Observable<PostsResponse> {
        return this.http.post<PostsResponse>("/api/posts/subscribed", topicIds);
    }
}
