import { Component, inject, OnInit } from '@angular/core';
import { Book, BookResponse } from '../../modules/books';
import { BookServices } from '../services/book-services';
import { Observable } from 'rxjs';
import { Api } from '../services/api';
import { AsyncPipe } from '@angular/common';

@Component({
  selector: 'app-view-books',
  imports: [AsyncPipe],
  templateUrl: './view-books.html',
  styleUrl: './view-books.css',
})
export class ViewBooks implements OnInit {

  // books: Book[] = [];

  //books!: Book[]; 

  //inject service after angular 18

  service = inject(BookServices)


  // constructor(private service : BookServices)
  // {

  // }




  books$ !: Observable<BookResponse>;

  ngOnInit(): void {
    
    // this.service.getBooks().subscribe(
    //   data => {
    //     this.books = data.content;
    //     console.log(data);
    //   },
    //   err => console.log(err)
    // );

    //no need to subscribe here after angular 18
    this.books$ = this.service.getBooks();  
  }
}
