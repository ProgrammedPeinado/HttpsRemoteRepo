import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  styleUrls: ['./directives.component.css']
})
export class DirectivesComponent implements OnInit {
  message : string = "This is a message from component"
  flag : boolean = false
  months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "July"]
  numbers = [12, 5, 34, 76, 56, 45, 43, 89]
  constructor() { }

  ngOnInit(): void {
  }

}
