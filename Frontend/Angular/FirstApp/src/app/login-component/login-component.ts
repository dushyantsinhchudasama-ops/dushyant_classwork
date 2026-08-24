import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-login-component',
  imports: [ReactiveFormsModule],
  templateUrl: './login-component.html',
  styleUrl: './login-component.css',
})
export class LoginComponent {

  login: FormGroup = new FormGroup({
    userName: new FormControl('',[Validators.required]),
    password: new FormControl('', [Validators.required])
  });

  submitLogin()
  {
    console.log
  }
}
