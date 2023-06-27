import { Component, OnInit } from '@angular/core';
import { CartService } from '../appServices/cart.service';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent
{

  foods = this.cartService.getItems();
  displayedColumns = ['name', 'price'];
  totalPrice = this.getCurrentTotal();

  constructor(private cartService : CartService, private router : Router)
  {
  }

  getCurrentTotal(): Number
  {
    let sum: number = 0;
    this.cartService.getItems().forEach(i => sum+= Number(i.price));;
    return Math.round(sum*100)/100;
  }

  purchaseConfirm()
  {
    window.alert("Thank you for your purchase!");
    this.router.navigate(['/']);
  }
}
