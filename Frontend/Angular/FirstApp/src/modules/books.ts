
// // export class Book
// // {
// //     bookId: number=0;
// //     title: string = '';
// //     isbn: string ='';
// //     price: number=0;
// //     stock:number=0;
// //     averageRating:number=0;
// // }

// // export interface BookResponse
// // {
// //     content: Book[];
// //       totalElements: number;
// //       totalPages: number;
// //       size: number;
// //       number: number;
// // }


// import { Publisher } from './publisher';

// export interface Book {

//   bookId: number;

//   title: string;

//   isbn: string;

//   price: number;

//   publisher: Publisher;

// }

export interface Publisher {
  publisherId: number;
  publisherName: string;
}

export interface Book {
  bookId: number;
  title: string;
  isbn: string;
  price: number;
  stock: number;
  averageRating: number;
  publisher: Publisher;
}

export interface BookResponse {
  content: Book[];
  pageNumber: number;
  pageSize: number;
  totalElements: number;
  totalPages: number;
  last: boolean;
}