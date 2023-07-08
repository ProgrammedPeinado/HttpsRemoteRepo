import { Component, EventEmitter, Output,  OnInit } from '@angular/core';

@Component({
  selector: 'app-child2-component',
  templateUrl: './child2-component.component.html',
  styleUrls: ['./child2-component.component.css']
})
export class Child2ComponentComponent implements OnInit {
  msgToParent : string = 'This is a message to Parent'
  @Output() childEvent = new EventEmitter()

  childEventHandler()
  {
    this.childEvent.emit(this.msgToParent)
  }

  constructor() { }

  ngOnInit(): void {
  }

}
