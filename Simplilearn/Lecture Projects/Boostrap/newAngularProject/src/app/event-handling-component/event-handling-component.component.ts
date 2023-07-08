import { asLiteral } from '@angular/compiler/src/render3/view/util';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-event-handling-component',
  templateUrl: './event-handling-component.component.html',
  styleUrls: ['./event-handling-component.component.css']
})
export class EventHandlingComponentComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  displayMsg()
  {
    alert("Hello World")
  }

}
