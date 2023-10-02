import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DvdMenuComponent } from './dvd-menu.component';

describe('DvdMenuComponent', () => {
  let component: DvdMenuComponent;
  let fixture: ComponentFixture<DvdMenuComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DvdMenuComponent]
    });
    fixture = TestBed.createComponent(DvdMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
