import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Food } from 'src/app/appModels/food.model';
import { FoodService } from 'src/app/appServices/food.service';

@Component({
  selector: 'app-food',
  templateUrl: './food.component.html',
  styleUrls: ['./food.component.css']
})
export class FoodComponent implements OnInit
{
  foodForm: FormGroup;
  showModal: boolean = false;
  editMode: boolean = false;

  foods: Food[]

  constructor(
    private fb: FormBuilder,
    private foodService: FoodService,
  ) { }

  ngOnInit(): void {
    this.getFood()
    this.foodForm = this.fb.group(
      {
        id: [''],
        name: [''],
        category: [''],
        tag: ['']
      }
    )
  }

  onFoodSubmit() {
    if (this.foodForm.valid) {
      // console.log(this.foodForm.value);
      if (this.editMode) {
        this.foodService.updateFood(this.foodForm.value).subscribe(
          (response) => {
            console.log(response);
            this.getFood();
          },
          (err) => { console.log(err) }
        )
      } else {
        this.foodService.addFood(this.foodForm.value).subscribe(
          (response) => {
            console.log(response);
            this.getFood();
          },
          (err) => { console.log(err) }
        )

      }
      this.onReset();
      this.onCloseModal();

    } else {
      let key = Object.keys(this.foodForm.controls);
      key.filter(data => {
        let control = this.foodForm.controls[data];
        if (control.errors != null) {
          control.markAsTouched();
        }
      })
    }
  }

  getFood() {
    this.foodService.getFoodList().subscribe((response: Food[]) => {
      //console.log(response);
      this.foods = response
    })
  }

  onEditFood(food : Food) {
    this.editMode = true;
    this.showModal = true;
    this.foodForm.patchValue(food);
  }

  // @ts-ignore: Object is possibly 'null'.
  onDeleteFood(id) {

    if (confirm('Do you want to delete this food?')) {
      // @ts-ignore: Object is possibly 'null'.
      this.foodService.deleteFood(id).subscribe(
        (response) => {
          alert('Deleted successfully');
          this.getFood()
        },
        (err) => { console.log(err) }
      )
    }
  }

  onAddFood() {
    this.showModal = true;
    console.log(this.showModal)
  }

  onCloseModal() {
    this.showModal = false;
    this.onReset();
    this.editMode = false;
  }

  onReset() {
    this.foodForm.reset({
      name: '',
      category: '',
      tag: ''
    });
  }

}
