import { Component, OnInit } from '@angular/core';
import { EmphttpService } from '../emphttp.service';
import { IEmployee } from '../IEmployee';

@Component({
  selector: 'app-emphttp',
  templateUrl: './emphttp.component.html',
  styleUrls: ['./emphttp.component.css']
})
export class EmphttpComponent implements OnInit {
  emps : IEmployee[] = []
  constructor(private empHttpService : EmphttpService) { }

  ngOnInit(): void {
    this.empHttpService.getEmployees().subscribe(data => this.emps = data)
  }

}
