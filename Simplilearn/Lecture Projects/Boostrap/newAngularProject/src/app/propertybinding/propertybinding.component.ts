import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-propertybinding',
  templateUrl: './propertybinding.component.html',
  styleUrls: ['./propertybinding.component.css']
})
export class PropertybindingComponent implements OnInit {
  flag : boolean = false
  uname : string = "Smith"
  constructor() { }

  ngOnInit(): void {
  }

}
