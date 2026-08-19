import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCategoryTemplate } from './add-category-template';

describe('AddCategoryTemplate', () => {
  let component: AddCategoryTemplate;
  let fixture: ComponentFixture<AddCategoryTemplate>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddCategoryTemplate],
    }).compileComponents();

    fixture = TestBed.createComponent(AddCategoryTemplate);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
