import { Component, OnInit } from '@angular/core';
import { Api } from '../services/api';
import { Category } from '../../modules/categories';

@Component({
  selector: 'app-view-categories',
  standalone: true,
  imports: [],
  templateUrl: './view-categories.html',
  styleUrl: './view-categories.css'
})
export class ViewCategories implements OnInit {

  categories: Category[] = [];

  constructor(private service: Api) {}


  // ngOnInit(): void {

  //   this.api.getCategories().subscribe({
  //     next: (data) => {

  //       this.categories = data.content;

  //       console.log(data);
  //       console.log(this.categories);

  //     },

  //     error: (error) => {
  //       console.log('Error:', error);
  //     }
  //   });
 
  // }

  ngOnInit(): void {

    this.service.getCategories().subscribe(
      data => {
        this.categories = data.content;
        console.log(data);
      },
      err => console.log(err)
    );

  }
}