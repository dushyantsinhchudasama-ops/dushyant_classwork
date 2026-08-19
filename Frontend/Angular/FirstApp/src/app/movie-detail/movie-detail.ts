import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Movie } from '../../modules/movies';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-movie-detail',
  imports: [DatePipe],
  templateUrl: './movie-detail.html',
  styleUrl: './movie-detail.css',
})
export class MovieDetail {

  @Input() dataFromParent: string = '';
  @Input() movieFromParent: Movie = {movieId: 0, movieTitle: '', movieRating: 0, releaseDate: new Date(), genreId: 0};

  @Output() dataToParent : EventEmitter<string> = new EventEmitter<string>();


  //method for sending the data to parent component:
  sendDataToParend()
  {
    this.dataToParent.emit("This is the data from the child");
  }
}