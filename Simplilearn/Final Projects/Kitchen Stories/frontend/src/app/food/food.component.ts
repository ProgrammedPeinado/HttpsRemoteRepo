import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Food } from '../appModels/food.model';
import { FoodService } from '../appServices/food.service';
import { NgIf } from '@angular/common';
import { LoginComponent } from '../authentication/login/login.component';

@Component({
  selector: 'app-food',
  templateUrl: './food.component.html',
  styleUrls: ['./food.component.css'],
})

export class FoodComponent
{
  isUserLoggedIn = false;
  foods: Food[];
  displayedColumns = ['name','tag', 'actions', 'price'];

  showFiller = false;
  constructor(private router: Router, private foodService: FoodService) { }

  ngOnInit()
  {
    this.fetchFoods();

    let storeData = localStorage.getItem("isUserLoggedIn");
      console.log("StoreData: " + storeData);

      if( storeData != null && storeData == "true")
         this.isUserLoggedIn = true;
      else


         this.isUserLoggedIn = false
  }

  fetchFoods()
    {
      this.foodService.getFoodList().subscribe((data: Food[])=>
        {
          this.foods = data;
          console.log ('Data requested');
          console.log(this.foods);
        });
    }
}
