import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddBookReactiveComponent } from './add-book-reactive.component';

describe('AddBookReactiveComponent', () => {
  let component: AddBookReactiveComponent;
  let fixture: ComponentFixture<AddBookReactiveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddBookReactiveComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(AddBookReactiveComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
