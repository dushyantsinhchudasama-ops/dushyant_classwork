export class Category {

  categoryId: number = 0;
  categoryName: string = '';
  description: string = '';
  isDeleted: boolean = false;

}


export interface CategoryResponse {
  content: Category[];
  totalElements: number;
  totalPages: number;
  size: number;
  number: number;
}