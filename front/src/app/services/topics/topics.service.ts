import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { TopicInterface } from "../../interfaces/Topic";


interface TopicsResponse {
    topics: TopicInterface[];
}


@Injectable({
    providedIn: "root"
})


export class TopicsService {
    private topicsUrl: string;


    /* Get the API URL */
    constructor(private http: HttpClient) {
        this.topicsUrl = "/api/topics";
    }


    /* Get all the topics */
    public getTopics(): Observable<TopicsResponse> {
        return this.http.get<TopicsResponse>(this.topicsUrl);
    }


    /* Get the topics for a specifc user */
    public getTopicsForUser(userId: number): Observable<TopicsResponse> {
        return this.http.get<TopicsResponse>(`${this.topicsUrl}/user/${userId}`);
    }
}
