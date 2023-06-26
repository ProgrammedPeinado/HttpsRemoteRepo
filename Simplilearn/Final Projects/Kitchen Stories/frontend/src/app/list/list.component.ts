import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table'

import { Food } from 'src/app/appModels/food.model';
import { FoodService } from '../appServices/food.service';

import { AuthGuard } from '../auth.guard';
import { AuthService } from '../appServices/auth.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  foods: Food[];
  displayedColumns = ['name', 'category', 'tag', 'actions', 'price'];

  constructor(private foodService : FoodService, private router: Router)
  {

  }

  ngOnInit()
  {
    this.fetchFoods();
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

    editFood(id)
    {
      this.router.navigate([`/update/${id}`]);
    }

    deleteFood(id)
    {
      this.foodService.deleteFood(id).subscribe(()=>
      {
        this.fetchFoods();
      })
    }

}
