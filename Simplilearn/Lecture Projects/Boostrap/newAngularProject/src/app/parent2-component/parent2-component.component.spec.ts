import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Parent2ComponentComponent } from './parent2-component.component';

describe('Parent2ComponentComponent', () => {
  let component: Parent2ComponentComponent;
  let fixture: ComponentFixture<Parent2ComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Parent2ComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Parent2ComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
