import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";

@Injectable()
export class BotService {
    private readonly URL = "localhost:8080"

    constructor(private http: HttpClient) {}

    getBot(botId: String) {
        return this.http.post(this.URL + '/bot/getBot', botId)
    }
}