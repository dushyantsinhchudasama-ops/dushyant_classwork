import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { GenreDemo } from './genre-demo/genre-demo';
import { DirectiveDemo } from './directive-demo/directive-demo';
import { Home } from './home/home';
import { MovieDetail } from './movie-detail/movie-detail';
import { ViewCategories } from './view-categories/view-categories';
import { ViewBooks } from './view-books/view-books';
import { AddCategoryTemplate } from './add-category-template/add-category-template';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, GenreDemo, DirectiveDemo, Home, MovieDetail, ViewCategories, ViewBooks, AddCategoryTemplate],
  templateUrl: './app.html',
  //template: `<h2> This is the header from the Template of the component </h2>
            //  <h3> This is another header in the template component</h3>`,
   
  styleUrl: './app.css'

  //here we are applying inline css
  //styles: ['h3{color: aqua}', 'h2{color: bisque}'] 
})
export class App {
  title = signal('FirstApp');

}
