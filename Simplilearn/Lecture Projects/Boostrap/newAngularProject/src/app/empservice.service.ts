import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmpserviceService {

  employees = [
    {"id": 1010, "name":"John", "designation":"Developer"},
    {"id" : 1234, "name" : "Smith" , "designation" : "Manager"},
    {"id" : 5643, "name" : "Jane" , "designation" : "Tester"},
    {"id" : 1245, "name" : "Jack" , "designation" : "HR"},
    {"id" : 6754, "name" : "Rose" , "designation" : "Developer"},
    {"id" : 9087, "name" : "John" , "designation" : "Sr. Developer"}
  ]

  getEmployees()
  {
    return this.employees
  }

  constructor() { }
}
