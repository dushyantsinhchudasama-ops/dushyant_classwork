import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'movieDiscount',
  standalone: true
})
export class MovieDiscountPipe implements PipeTransform {

  transform(value: number): string {

    if(value > 4)
    {
      return '20% Discount';
    }
    else if(value == 4)
    {
      return '10% Discount';
    }
    else
    {
      return '5% Discount';
    }

  }

}