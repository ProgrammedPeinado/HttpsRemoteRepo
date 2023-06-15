import { Component, OnInit } from '@angular/core';
import { FoodComponent } from '../food/food/food.component';
import { FoodService } from '../appServices/food.service';
import { RouterModule, Routes } from '@angular/router';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  constructor(private foodService : FoodService)
  {

  }

  ngOnInit()
  {
    this.foodService.getFoods().subscribe((food) =>
    {
      console.log(food);
    });
  }

}
