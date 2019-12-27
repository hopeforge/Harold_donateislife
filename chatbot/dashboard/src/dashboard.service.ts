import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from "@angular/core";

@Injectable()
export class DashboardService {
    private readonly URL = "api/dashboard";
    
    constructor(private http: HttpClient) {}
    
    get1() {
        return this.http.get(this.URL + '/graph')
    }
    get2() {
        return this.http.get(this.URL + '/graph2')
    }
}