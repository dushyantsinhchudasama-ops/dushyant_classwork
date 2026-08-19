import { DatePipe } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-genre-demo',
  imports: [FormsModule, DatePipe],
  templateUrl: './genre-demo.html',
  styleUrl: './genre-demo.css',
})
export class GenreDemo {

  //DECLARING GENERE VARIABLES 

  genreID: number = 101;
  genreDesc: string = "Action movie";
  genreCode: string = "ACT";

  num: number = 100;
  
  selectedState: string = '';

  getString() : string {
    return "Hello Angular";
  }

  updGenere(event: any)
  {
    this.genreCode = event.target.value;
  }

  updNum()
  {
    this.num *= 3;
  }
}
