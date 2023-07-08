import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PipedemocomponentComponent } from './pipedemocomponent.component';

describe('PipedemocomponentComponent', () => {
  let component: PipedemocomponentComponent;
  let fixture: ComponentFixture<PipedemocomponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PipedemocomponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PipedemocomponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
