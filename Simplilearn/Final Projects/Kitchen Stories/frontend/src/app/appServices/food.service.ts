import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Food } from '../appModels/food.model'

@Injectable({
  providedIn: 'root'
})
export class FoodService {
  uri = 'http://localhost:4000'
  constructor(private http : HttpClient) { }

  addFood(food:Food)
  {
    return this.http.post(`${this.uri}/foods/add`, food);
  }

  addFoodI(name: string, category: string, tag: string)
  {
    const food =
    {
      name: name,
      category: category,
      tag: tag
    }
    return this.http.post(`${this.uri}/foods/add`, food);
  }

  getFoods()
  {
    return this.http.get(`${this.uri}/foods`);
  }

  getFoodList()
  {
    return this.http.get<Food[]>(`${this.uri}`);
  }

  getFoodbyId(id: string)
  {
    return this.http.get(`${this.uri}/foods/${id}`);
  }

  updateFood(food: Food)
  {
    return this.http.post(`${this.uri}`, food);
  }

  updateFoodI(id: string, name: string, category: string, tag: string)
  {
    const food =
    {
      name: name,
      category: category,
      tag: tag
    }
    return this.http.post(`${this.uri}/foods/update/${id}`, food);
  }

  deleteFood(id: string)
  {
    return this.http.delete(`${this.uri}/foods/delete/${id}`);
  }
}
