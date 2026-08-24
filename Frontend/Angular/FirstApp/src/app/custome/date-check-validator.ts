import {
  AbstractControl,
  ValidationErrors
} from '@angular/forms';


// Custom validator
export function DateCheckValidator(
  control: AbstractControl
): ValidationErrors | null {

  // If there is no value
  if (!control.value) {

    return null;

  }


  const selectedDate = new Date(control.value);

  const today = new Date();


  // If selected date is in future
  if (selectedDate > today) {

    return {
      futureDate: true
    };

  }


  return null;
}