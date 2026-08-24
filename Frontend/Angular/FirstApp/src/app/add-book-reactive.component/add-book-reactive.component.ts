import {
  Component,
  OnInit,
  inject
} from '@angular/core';

import {
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators
} from '@angular/forms';

import { BookApiService } from '../services/book-api.service';

import { Publisher } from '../../modules/publisher';

@Component({
  selector: 'app-add-book-reactive',

  standalone: true,

  imports: [
    ReactiveFormsModule
  ],

  templateUrl: './add-book-reactive.component.html'
})
export class AddBookReactiveComponent
  implements OnInit {


  // Publisher list
  publishers: Publisher[] = [];


  // Inject service
  service = inject(BookApiService);


  // Reactive Form
  addBookForm: FormGroup = new FormGroup({

    title: new FormControl(
      '',
      [
        Validators.required,
        Validators.minLength(5)
      ]
    ),


    isbn: new FormControl(
      '',
      [
        Validators.required
      ]
    ),


    price: new FormControl(
      0,
      [
        Validators.required,
        Validators.min(0.01)
      ]
    ),


    publisherId: new FormControl(
      '',
      [
        Validators.required
      ]
    )

  });


  // Called automatically after constructor
  ngOnInit(): void {

    console.log('Add Book Component Loaded');


    // Get publishers
    this.service.getPublishers()
      .subscribe({

        next: (data) => {

          console.log('Publishers:');

          console.log(data);

          this.publishers = data;

        },

        error: (error) => {

          console.log(
            'Error while loading publishers'
          );

          console.log(error);

        }

      });

  }


  // Add Book
  addBook(): void {

    console.log(
      this.addBookForm.value
    );


    if (this.addBookForm.invalid) {

      console.log(
        'Form is invalid'
      );

      this.addBookForm.markAllAsTouched();

      return;

    }


    this.service
      .addBook(this.addBookForm.value)
      .subscribe({

        next: (data) => {

          console.log(
            'Book Added Successfully'
          );

          console.log(data);

        },

        error: (error) => {

          console.log(
            'Error while adding book'
          );

          console.log(error);

        }

      });

  }


  // Getter for Title
  get bookTitle(): FormControl {

    return this.addBookForm.get(
      'title'
    ) as FormControl;

  }


  // Getter for ISBN
  get isbn(): FormControl {

    return this.addBookForm.get(
      'isbn'
    ) as FormControl;

  }


  // Getter for Price
  get price(): FormControl {

    return this.addBookForm.get(
      'price'
    ) as FormControl;

  }


  // Getter for Publisher
  get publisherId(): FormControl {

    return this.addBookForm.get(
      'publisherId'
    ) as FormControl;

  }

}