import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterfollowupComponent } from './registerfollowup.component';

describe('RegisterfollowupComponent', () => {
  let component: RegisterfollowupComponent;
  let fixture: ComponentFixture<RegisterfollowupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterfollowupComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterfollowupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
