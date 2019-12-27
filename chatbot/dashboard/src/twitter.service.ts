import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from "@angular/core";

@Injectable()
export class TwitterService {
    private readonly URL = "api/twitter";
    
    constructor(private http: HttpClient) {}
    
    getTwittes(item: String) {
        let header = new HttpHeaders();
        header.set('Access-Control-Allow-Origin', '*');
        console.log(item)
        item = item.replace("#", "");
        return this.http.get(this.URL + '/search/?messages=' + item )
    }
}