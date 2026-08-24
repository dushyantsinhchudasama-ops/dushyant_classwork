import { Routes } from '@angular/router';

import { Home } from './home/home';
import { GenreDemo } from './genre-demo/genre-demo';
import { DirectiveDemo } from './directive-demo/directive-demo';
import { MovieDetail } from './movie-detail/movie-detail';
import { ViewCategories } from './view-categories/view-categories';
import { ViewBooks } from './view-books/view-books';
import { AddCategoryTemplate } from './add-category-template/add-category-template';
import { AddBookReactiveComponent } from './add-book-reactive.component/add-book-reactive.component';
import { ErrorComponent } from './error-component/error-component';

export const routes: Routes = [
  { path: '', component: Home },

  //for lazy loading
  { path: 'genre-demo', loadComponent: ()=>import('./genre-demo/genre-demo').then(m=>m.GenreDemo) },
  { path: 'directives', loadComponent: ()=>import('./directive-demo/directive-demo').then(m=>m.DirectiveDemo) },
  { path: 'movie-detail', loadComponent: ()=>import('./movie-detail/movie-detail').then(m=>m.MovieDetail) },
  { path: 'categories', loadComponent: ()=>import('./view-categories/view-categories').then(m=>m.ViewCategories) },
  { path: 'books', loadComponent: ()=>import('./view-books/view-books').then(m=>m.ViewBooks) },

  // Form pages
  { path: 'add-category', loadComponent: ()=>import('./add-category-template/add-category-template').then(m=>m.AddCategoryTemplate) },
  { path: 'add-book', component: AddBookReactiveComponent },
  { path: '**', loadComponent: ()=>import('./error-component/error-component').then(m=>m.ErrorComponent)}
];