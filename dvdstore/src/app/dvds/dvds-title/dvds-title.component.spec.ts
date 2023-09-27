import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DvdsTitleComponent } from './dvds-title.component';

describe('DvdsTitleComponent', () => {
  let component: DvdsTitleComponent;
  let fixture: ComponentFixture<DvdsTitleComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DvdsTitleComponent]
    });
    fixture = TestBed.createComponent(DvdsTitleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
