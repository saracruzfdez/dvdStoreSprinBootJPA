import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InscriptionFormTitleComponent } from './inscription-form-title.component';

describe('InscriptionFormTitleComponent', () => {
  let component: InscriptionFormTitleComponent;
  let fixture: ComponentFixture<InscriptionFormTitleComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [InscriptionFormTitleComponent]
    });
    fixture = TestBed.createComponent(InscriptionFormTitleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
