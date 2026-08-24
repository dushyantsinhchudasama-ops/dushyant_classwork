import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Observable } from 'rxjs';

import { Category } from '../../modules/categories';
import { Api } from '../services/api';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-add-category-template',
  imports: [FormsModule, CommonModule],
  templateUrl: './add-category-template.html',
  styleUrl: './add-category-template.css',
})
export class AddCategoryTemplate {

  category: Category = {
    categoryId: 0,
    categoryName: '',
    description: '',
    isDeleted: false
  };

  service = inject(Api);

  result$!: Observable<any>;

  addCategory() {

    const categoryRequest = {
      categoryName: this.category.categoryName,
      description: this.category.description
    };

    console.log(categoryRequest);

    this.result$ = this.service.addCategory(categoryRequest);

    this.result$.subscribe(
      data => {
        console.log(data);
      },
      error => {
        console.log(error); 
      }
    );
  }
}