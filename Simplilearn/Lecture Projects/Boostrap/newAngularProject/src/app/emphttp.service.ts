import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IEmployee } from './IEmployee';


@Injectable({
  providedIn: 'root'
})
export class EmphttpService {
  private url : string = "/assets/data/employees.json"
  constructor(private http : HttpClient) { }

  getEmployees() : Observable<IEmployee[]>
  {
    return this.http.get<IEmployee[]>(this.url)
  }
}
