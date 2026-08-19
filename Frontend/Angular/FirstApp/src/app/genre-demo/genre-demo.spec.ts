import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GenreDemo } from './genre-demo';

describe('GenreDemo', () => {
  let component: GenreDemo;
  let fixture: ComponentFixture<GenreDemo>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GenreDemo],
    }).compileComponents();

    fixture = TestBed.createComponent(GenreDemo);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
