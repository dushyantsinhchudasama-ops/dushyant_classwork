import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category, CategoryResponse } from '../../modules/categories';

@Injectable({
  providedIn: 'root',
})
export class Api {

  constructor(private http: HttpClient) {}

  getCategories(): Observable<CategoryResponse> {

    return this.http.get<CategoryResponse>(
      'http://localhost:8080/api/categories'
    );
  }


  addCategory(category: any): Observable<any> {

  return this.http.post<any>(
    'http://localhost:8080/api/categories',
    category
  );

}
}