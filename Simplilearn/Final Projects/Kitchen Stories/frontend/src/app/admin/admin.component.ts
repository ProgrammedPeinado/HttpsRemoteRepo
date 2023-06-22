import { Component, OnDestroy, OnInit } from '@angular/core';
import { AuthService } from '../appServices/auth.service';
import { MatCardModule } from '@angular/material/card'

import { FormGroup, FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { filter, Subject, take, takeUntil } from 'rxjs';

@Component({
   selector: 'app-admin',
   templateUrl: './admin.component.html',
   styleUrls: ['./admin.component.css']
})

export class AdminComponent implements OnInit, OnDestroy {
  public loginValid = true;
  public username = '';
  public password = '';

  private _destroySub$ = new Subject<void>();
  private readonly returnUrl: string;

  constructor(
    private _route: ActivatedRoute,
    private _router: Router,
    private _authService: AuthService
  ) {
    this.returnUrl = this._route.snapshot.queryParams['returnUrl'] || '/list';
  }

  public ngOnInit(): void
  {
  }

  public ngOnDestroy(): void
  {
    this._destroySub$.next();
  }
}
