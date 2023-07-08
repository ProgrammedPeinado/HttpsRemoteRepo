import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EventHandlingComponentComponent } from './event-handling-component.component';

describe('EventHandlingComponentComponent', () => {
  let component: EventHandlingComponentComponent;
  let fixture: ComponentFixture<EventHandlingComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EventHandlingComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EventHandlingComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
