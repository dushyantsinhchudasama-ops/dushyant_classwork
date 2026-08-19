import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Category } from '../../modules/categories';

@Component({
  selector: 'app-add-category-template',
  standalone:true,
  imports: [FormsModule],
  templateUrl: './add-category-template.html',
  styleUrl: './add-category-template.css',
})
export class AddCategoryTemplate {

  category : Category = {categoryId : 0, categoryName : "Test cate", description:"test description" , isDeleted : false};

  addCategory()
  {
    console.log(this.category);
  }

}
