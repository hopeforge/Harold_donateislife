import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from "@angular/core";

@Injectable()
export class PerfilService {
    private readonly URL = "api/dashboard";
    
    constructor(private http: HttpClient) {}
    
    getUsers() {
        return this.http.get(this.URL + '/risk' );
    }
}