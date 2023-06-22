import { Component, OnInit } from '@angular/core';
import { ReactiveFormsModule, FormsModule, FormGroup, FormControl } from '@angular/forms';
import { AuthService } from 'src/app/appServices/auth.service';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit
{
  userName: string;
  password: string;
  formData: FormGroup;

  constructor(private authService : AuthService, private router: Router, private fb: FormBuilder)
  {
  }

  ngOnInit()
  {
      this.formData = this.fb.group(
      {
        userName: new FormControl(""),
        password: new FormControl(""),
      });
  }

  onClickSubmit(data: any)
  {
      this.userName = data.userName;
      this.password = data.password;

      console.log("Login username: " + this.userName);
      console.log("Login pass: " + this.password);

      this.authService.login(this.userName, this.password)
        .subscribe( data =>
          {
            console.log("Is Login Success: " + data);
            if(data) this.router.navigate(['/list']);
          });
  }
}
