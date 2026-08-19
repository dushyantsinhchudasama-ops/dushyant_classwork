
export class Book
{
    bookId: number=0;
    title: string = '';
    isbn: string ='';
    price: number=0;
    stock:number=0;
    averageRating:number=0;
}

export interface BookResponse
{
    content: Book[];
      totalElements: number;
      totalPages: number;
      size: number;
      number: number;
}