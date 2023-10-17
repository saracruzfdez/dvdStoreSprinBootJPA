import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginFormTitleComponent } from './login-form-title.component';

describe('LoginFormTitleComponent', () => {
  let component: LoginFormTitleComponent;
  let fixture: ComponentFixture<LoginFormTitleComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LoginFormTitleComponent]
    });
    fixture = TestBed.createComponent(LoginFormTitleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
