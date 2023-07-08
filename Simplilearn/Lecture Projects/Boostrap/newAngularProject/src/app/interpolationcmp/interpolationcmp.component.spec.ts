import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InterpolationcmpComponent } from './interpolationcmp.component';

describe('InterpolationcmpComponent', () => {
  let component: InterpolationcmpComponent;
  let fixture: ComponentFixture<InterpolationcmpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InterpolationcmpComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InterpolationcmpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
