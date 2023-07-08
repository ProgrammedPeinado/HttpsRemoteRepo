import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pipedemocomponent',
  templateUrl: './pipedemocomponent.component.html',
  styleUrls: ['./pipedemocomponent.component.css']
})
export class PipedemocomponentComponent implements OnInit {
  title : string = "Pipe Demo Application"
  today = new Date()
  emp =
  {
    empname: "John",
    designation: "Developer",
    technologies:{tech1:"Java", tech2:"Angular"}
  }
  names = ["John", "Smith", "Jack", "Jane", "Oliver", "Robert"]
  constructor() { }

  ngOnInit(): void {
  }

}
