import { Injectable } from '@angular/core';
import { Food } from '../appModels/food.model';

@Injectable({
  providedIn: 'root'
})
export class CartService
{
  foods: Food[] = [];

  addToCart(food: Food)
  {
    console.log(this.foods);
    this.foods.push(food);
  }

  getItems()
  {
    return this.foods;
  }

  clearCart()
  {
    this.foods = [];
    return this.foods;
  }
}
