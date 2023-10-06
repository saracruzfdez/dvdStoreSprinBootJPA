import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecuperationFormComponent } from './recuperation-form.component';

describe('RecuperationFormComponent', () => {
  let component: RecuperationFormComponent;
  let fixture: ComponentFixture<RecuperationFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RecuperationFormComponent]
    });
    fixture = TestBed.createComponent(RecuperationFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
