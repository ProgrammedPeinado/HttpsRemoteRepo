import { Component, OnInit } from '@angular/core';
import { CartService } from '../appServices/cart.service';


@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent
{

  foods = this.cartService.getItems();
  displayedColumns = ['name', 'quantity', 'price'];

  constructor(private cartService : CartService)
  {

  }

/*
  ngOnInit()
  {
    this.fetchFoods();
  }


  deleteFood(id)
  {
    this.foodService.deleteFood(id).subscribe(()=>
    {
      this.fetchFoods();
    })
  }
*/
}
