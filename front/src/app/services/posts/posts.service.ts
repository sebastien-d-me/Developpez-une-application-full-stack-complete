import { PostInterface, PostsRequest } from "../../interfaces/Post";
import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";


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


    /* Posts */
    public getPosts(): Observable<PostsResponse> {
        return this.http.get<PostsResponse>(this.postsUrl);
    }


    /* Specific post */
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
