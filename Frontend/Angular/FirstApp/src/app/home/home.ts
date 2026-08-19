import { NgClass } from '@angular/common';
import { Component } from '@angular/core';
import { Admin } from '../admin/admin';
import { Member } from '../member/member';
import { Highlight } from '../custome/directive/highlight';

@Component({
  selector: 'app-home',
  imports: [NgClass, Admin, Member, Highlight],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home {

  isActive: boolean = false;


switchRole(role: string)
{
  if(role == 'admin') {
  this.isActive = true;
  }
  else{
    this.isActive = false;
  }
}
}