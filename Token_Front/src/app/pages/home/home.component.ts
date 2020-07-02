import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  
  nombre: string = localStorage.getItem("name")

  /*ngOnInit(): void {
    if (this.id) {
      this.logInDiv=false
    } else {
      this.logInDiv=true;
    }
  }*/

  constructor() { }

  ngOnInit(): void {
  }

}
