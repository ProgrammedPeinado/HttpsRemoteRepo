import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FoodComponent } from './food/food/food.component';
import { SingleFoodComponent } from './single-food/single-food.component';
import { ListComponent } from './list/list.component';

import { FoodService } from './appServices/food.service';
import { RouterModule, Routes } from '@angular/router';

//Website routes
const routes: Routes =
[
  {path: '', component:FoodComponent},
  {path:'foods/:id', component:SingleFoodComponent},
  {path: 'list', component: ListComponent},
  {path: '', redirectTo: 'list', pathMatch: 'full'}
]

@NgModule({
  declarations: [
    AppComponent,
    FoodComponent,
    ListComponent,
    SingleFoodComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [FoodService],
  bootstrap: [AppComponent]
})
export class AppModule { }
