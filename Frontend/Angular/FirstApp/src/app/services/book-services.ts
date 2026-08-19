import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BookResponse } from '../../modules/books';

@Injectable({
  providedIn: 'root',
})
export class BookServices {

  constructor(private http:HttpClient){}

  getBooks(): Observable<BookResponse>
  {
    return this.http.get<BookResponse>(
      'http://localhost:8080/api/books'
    );
  }

}
