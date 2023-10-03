import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DvdFormMenuComponent } from './dvd-form-menu.component';

describe('DvdFormMenuComponent', () => {
  let component: DvdFormMenuComponent;
  let fixture: ComponentFixture<DvdFormMenuComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DvdFormMenuComponent]
    });
    fixture = TestBed.createComponent(DvdFormMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
