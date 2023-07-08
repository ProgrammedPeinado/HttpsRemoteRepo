import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-parent-component',
  templateUrl: './parent-component.component.html',
  styleUrls: ['./parent-component.component.css']
})
export class ParentComponentComponent implements OnInit {
  msgToChild : string = "Message to be send to child"
  anotherMsg : string = "Hope you receive this as well child"
  constructor() { }

  ngOnInit(): void {
  }

}
