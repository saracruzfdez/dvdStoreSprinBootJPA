import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DvdsMenuComponent } from './dvds-menu.component';

describe('DvdsMenuComponent', () => {
  let component: DvdsMenuComponent;
  let fixture: ComponentFixture<DvdsMenuComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DvdsMenuComponent]
    });
    fixture = TestBed.createComponent(DvdsMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
