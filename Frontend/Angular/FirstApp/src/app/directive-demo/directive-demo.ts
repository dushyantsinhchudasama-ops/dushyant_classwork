import { CommonModule, DatePipe, NgStyle } from '@angular/common';
import { Component } from '@angular/core';
import { Genre } from '../../modules/genre';
import { Movie } from '../../modules/movies';
import { MovieDiscountPipe } from '../custome/pipes/movie-type-pipe-pipe';
import { MovieDetail } from '../movie-detail/movie-detail';

@Component({
  selector: 'app-directive-demo',
  imports: [CommonModule, NgStyle, DatePipe, MovieDiscountPipe, MovieDetail],
  templateUrl: './directive-demo.html',
  styleUrl: './directive-demo.css',
})
export class DirectiveDemo {

  toDisplay: boolean = false;

  num : number = 100;

  listNum : number[] = [10,20,30,40,50];

  movieToChild : Movie = {movieId:0, movieTitle : '', movieRating : 0, releaseDate:new Date(), genreId:0};

  

  listGenre : Genre[] = [
    {genreId: 1, genreCode: 'A', genreDesc: 'Action'},
    {genreId: 2, genreCode: 'C', genreDesc: 'Comedy'},
    {genreId: 3, genreCode: 'D', genreDesc: 'Drama'},
    {genreId: 4, genreCode: 'H', genreDesc: 'Horror'},
    {genreId: 5, genreCode: 'R', genreDesc: 'Romance'}
  ];


  //for movies

  listMovie : Movie[] = [
    {movieId: 1, movieTitle: 'Movie 1', movieRating: 4.5, releaseDate: new Date('2022-01-01'), genreId: 1},
    {movieId: 2, movieTitle: 'Movie 2', movieRating: 3.5, releaseDate: new Date('2022-02-01'), genreId: 2},
    {movieId: 3, movieTitle: 'Movie 3', movieRating: 4.0, releaseDate: new Date('2022-03-01'), genreId: 3},
    {movieId: 4, movieTitle: 'Movie 4', movieRating: 2.5, releaseDate: new Date('2022-04-01'), genreId: 4},
    {movieId: 5, movieTitle: 'Movie 5', movieRating: 5.0, releaseDate: new Date('2022-05-01'), genreId: 5}
  ];


  checkEvenOdd(num: number): string {
    return num % 2 == 0 ? 'bold' : 'normal';
  }


  //function to send data to parent component
  updMovieToChild(i: number) {
    //console.log('Data sent to parent component:', movie);
    this.movieToChild = this.listMovie[i];
  }
  
}
