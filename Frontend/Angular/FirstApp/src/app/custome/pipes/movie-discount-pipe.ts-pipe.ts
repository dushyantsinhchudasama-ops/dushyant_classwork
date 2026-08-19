import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'movieDiscountPipeTs',
})
export class MovieDiscountPipeTsPipe implements PipeTransform {
  transform(value: unknown, ...args: unknown[]): unknown {
    return null;
  }
}
