import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-parent2-component',
  templateUrl: './parent2-component.component.html',
  styleUrls: ['./parent2-component.component.css']
})
export class Parent2ComponentComponent implements OnInit {
  msgFromChild : string = ''

  receiveMessage($event : any)
  {
    this.msgFromChild = $event
  }
  constructor() { }

  ngOnInit(): void {
  }

}
