import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-reactiveforms',
  templateUrl: './reactiveforms.component.html',
  styleUrls: ['./reactiveforms.component.css']
})
export class ReactiveformsComponent implements OnInit {
  loginForm : FormGroup = new FormGroup({
    uname : new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z]*')]),
    pword : new FormControl('', [Validators.required, Validators.minLength(8), Validators.maxLength(15)])
  })
  constructor() { }

  ngOnInit(): void {
  }

}
