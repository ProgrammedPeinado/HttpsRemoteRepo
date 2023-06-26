import { AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import { Router } from '@angular/router';
import { Food } from '../appModels/food.model';
import { FoodService } from '../appServices/food.service';
import { NgIf } from '@angular/common';
import { LoginComponent } from '../authentication/login/login.component';
import { AuthGuard } from '../auth.guard';
import { AuthService } from '../appServices/auth.service';
import { CartService } from '../appServices/cart.service';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';

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
  constructor(
    private router: Router,
    private foodService: FoodService,
    private cartService: CartService) { }

  ngOnInit()
  {
    this.fetchFoods();

    let storeData = localStorage.getItem("isUserLoggedIn");

      if( storeData != null && storeData == "true")
         this.isUserLoggedIn = true;
      else
         this.isUserLoggedIn = false;
  }

  fetchFoods()
  {
    this.foodService.getFoodList().subscribe((data: Food[])=>
      {
        this.foods = data;
      });
  }

  addToCart(food: Food)
  {
    this.cartService.addToCart(food);
    window.alert('Your product has been added to the cart!');
  }
}
