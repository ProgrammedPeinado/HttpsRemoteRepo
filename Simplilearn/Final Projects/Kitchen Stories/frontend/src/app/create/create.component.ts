import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FoodService } from '../appServices/food.service';

import { AuthGuard } from '../auth.guard';
import { AuthService } from '../appServices/auth.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  createForm: FormGroup;

  constructor(private foodService: FoodService, private fb: FormBuilder, private router: Router) {
    this.createForm = this.fb.group({
      name: ['', Validators.required],
      category: '',
      tag: '',
      price: ''
    });
  }

  addFood(name, category, tag, price) {
    this.foodService.addFoodI(name, category, tag, price).subscribe(() =>
    {
      this.router.navigate(['/list']);
    });
  }

  ngOnInit() {
  }

}
