import { TopicInterface } from "../../interfaces/Topic";
import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";


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


    /* Topics */
    public getTopics(): Observable<TopicsResponse> {
        return this.http.get<TopicsResponse>(this.topicsUrl);
    }


    /* Topics which user subscribed */
    public topicsCurrentUser(): Observable<TopicsResponse> {
        return this.http.get<TopicsResponse>(`${this.topicsUrl}/user/subscriptions`);
    }


    /* Subscribe the topic for User */
    public subscribeTopicForUser(topicId: number): Observable<void> {
        return this.http.post<void>(`${this.topicsUrl}/${topicId}/user/subscribe`, {});
    }


    /* Unsubscribe the topic for User */
    public unsubscribeTopicForUser(topicId: number): Observable<void> {
        return this.http.delete<void>(`${this.topicsUrl}/${topicId}/user/unsubscribe`);
    }
}
