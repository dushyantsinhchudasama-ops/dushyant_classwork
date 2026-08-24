import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Publisher } from '../../modules/publisher';
import { Book } from '../../modules/books';

// import { Book } from '../models/book';
// import { Publisher } from '../models/publisher';

@Injectable({
  providedIn: 'root'
})
export class BookApiService {

  publisherUrl: string =
    'http://localhost:8080/api/demo-publishers';

  bookUrl: string =
    'http://localhost:8080/api/demo-books';


  http = inject(HttpClient);


  // Get Publishers
  getPublishers(): Observable<Publisher[]> {

    return this.http.get<Publisher[]>(
      this.publisherUrl
    );

  }


  // Add Book
  addBook(book: any): Observable<Book> {

    return this.http.post<Book>(
      this.bookUrl,
      book
    );

  }

}