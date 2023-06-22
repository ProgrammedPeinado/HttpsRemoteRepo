import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Router, RouterStateSnapshot, CanActivate, UrlTree } from '@angular/router';
import { AuthService } from './appServices/auth.service';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private authService: AuthService, private router: Router) {}

  canActivate(
  next: ActivatedRouteSnapshot,
  state: RouterStateSnapshot): boolean | UrlTree {
     let url: string = state.url;

         return this.checkLogin(url);
     }

     checkLogin(url: string): true | UrlTree {
        console.log("Url: " + url)
        let val: string = localStorage.getItem('isUserLoggedIn');

        if(val != null && val == "true"){
           if(url == "/login")
              this.router.parseUrl('/list');
           else
              return true;
        } else {
           return this.router.parseUrl('/login');
        }
     }
}
