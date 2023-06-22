import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

import { MatSnackBar } from '@angular/material/snack-bar';

import { FoodService } from '../appServices/food.service';
import { Food } from '../appModels/food.model';


@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})

export class EditComponent implements OnInit
{

  id: String;
  food: any = {};
  updateForm: FormGroup;

  constructor(private foodService: FoodService, private router: Router, private route: ActivatedRoute, private snackBar: MatSnackBar, private fb: FormBuilder)
  {
    this.createForm();
  }

  createForm()
  {
    this.updateForm = this.fb.group({
      name: ['', Validators.required],
      category: '',
      tag: '',
      price: ''
    });
  }

  ngOnInit(): void
  {
      this.route.params.subscribe(params =>
      {
        this.id = params.id;
        this.foodService.getFoodbyId(this.id).subscribe(res =>
          {
            this.food = res;
            this.updateForm.get('name').setValue(this.food.name);
            this.updateForm.get('category').setValue(this.food.category);
            this.updateForm.get('tag').setValue(this.food.tag);
            this.updateForm.get('price').setValue(this.food.price);
          });
      });
  }

  updateFood(name, category, tag, price)
  {
    this.foodService.updateFoodI(this.id, name, category, tag, price).subscribe(()=>
    {
      this.snackBar.open('Food updated successfully', 'OK', {duration: 3000})
    })
  }
}
