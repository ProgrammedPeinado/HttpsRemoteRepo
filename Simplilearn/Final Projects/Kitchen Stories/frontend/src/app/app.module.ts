import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { MatToolbarModule} from '@angular/material/toolbar'
import { MatFormFieldModule } from '@angular/material/form-field'
import { MatInputModule } from '@angular/material/input'
import { MatOptionModule } from '@angular/material/core'
import { MatSelectModule } from '@angular/material/select'
import { MatIconModule } from '@angular/material/icon'
import { MatButtonModule } from '@angular/material/button'
import { MatCardModule } from '@angular/material/card'
import { MatTableModule } from '@angular/material/table'
import { MatDividerModule } from '@angular/material/divider'
import { MatSnackBarModule } from '@angular/material/snack-bar'
import { MatSidenavModule } from '@angular/material/sidenav'
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FoodComponent } from './food/food.component';
import { ListComponent } from './list/list.component';
import { AdminComponent } from './admin/admin.component';
import { LoginComponent } from './authentication/login/login.component';
import { LogoutComponent } from './authentication/logout/logout.component';
import { CreateComponent } from './create/create.component';
import { EditComponent } from './edit/edit.component';

import { CanActivate, RouterModule, Routes, Router } from '@angular/router';
import { AuthService } from './appServices/auth.service';
import { FoodService } from './appServices/food.service';
import { AuthGuard } from './auth.guard';
import { CartComponent } from './cart/cart.component';


//Website routes -- No need for delete or admin since they don't have a separate component site
const routes: Routes =
[
  {path: '', component: FoodComponent},
  {path: 'login', component: LoginComponent},
  {path: 'logout', component: LogoutComponent},
  {path: 'cart', component: CartComponent},
  {path: 'list', component: ListComponent, canActivate: [ AuthGuard]},
  {path: 'create', component: CreateComponent, canActivate: [ AuthGuard]},
  {path: 'update/:id', component: EditComponent, canActivate: [ AuthGuard]},
  {path: '', redirectTo: 'list', pathMatch: 'full'}
]

@NgModule({
  declarations:
  [
    AppComponent,
    FoodComponent,
    ListComponent,
    LoginComponent,
    CreateComponent,
    EditComponent,
    AdminComponent,
    CartComponent
  ],
  imports:
  [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    RouterModule.forRoot(routes),
    MatToolbarModule,
    MatFormFieldModule,
    MatInputModule,
    MatOptionModule,
    MatSelectModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    MatTableModule,
    MatDividerModule,
    MatSnackBarModule,
    MatSidenavModule
  ],
  providers: [FoodService, AuthService, AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
