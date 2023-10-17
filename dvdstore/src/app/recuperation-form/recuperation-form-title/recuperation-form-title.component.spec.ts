import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecuperationFormTitleComponent } from './recuperation-form-title.component';

describe('RecuperationFormTitleComponent', () => {
  let component: RecuperationFormTitleComponent;
  let fixture: ComponentFixture<RecuperationFormTitleComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RecuperationFormTitleComponent]
    });
    fixture = TestBed.createComponent(RecuperationFormTitleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
