import { AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import { Router } from '@angular/router';
import { Food } from '../appModels/food.model';
import { FoodService } from '../appServices/food.service';
import { NgIf } from '@angular/common';
import { LoginComponent } from '../authentication/login/login.component';
import { AuthGuard } from '../auth.guard';
import { AuthService } from '../appServices/auth.service';
import { CartService } from '../appServices/cart.service';
import { MatTableDataSource, MatTableModule, _MatTableDataSource } from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';
import { MatFormField } from '@angular/material/form-field';
import { DataSource } from '@angular/cdk/collections';
import { MatSort } from '@angular/material/sort';
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
  dataSource = new MatTableDataSource<Food>();
  resultsLength = 0;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;


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

  ngAfterViewInit()
  {
    this.foodService.getFoodList().subscribe(foods =>
      {
        this.dataSource.data = foods;
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      });
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

  applyFilter(event: Event)
  {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}
