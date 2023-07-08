import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmphttpComponent } from './emphttp.component';

describe('EmphttpComponent', () => {
  let component: EmphttpComponent;
  let fixture: ComponentFixture<EmphttpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmphttpComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmphttpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
