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


    /* Get the topics for the current logged user */
    public getTopicsForUser(): Observable<TopicsResponse> {
        return this.http.get<TopicsResponse>(`${this.topicsUrl}/user/subscriptions`);
    }


    /* Subscribe a specific topic for a specifc user */
    public subscribeTopicForUser(topicId: number): Observable<void> {
        return this.http.post<void>(`${this.topicsUrl}/${topicId}/user/subscribe`, {});
    }


    /* Unsubscribe a specific topic for a specifc user */
    public unsubscribeTopicForUser(topicId: number): Observable<void> {
        return this.http.delete<void>(`${this.topicsUrl}/${topicId}/user/unsubscribe`);
    }
}
