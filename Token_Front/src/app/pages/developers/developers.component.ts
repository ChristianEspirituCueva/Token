import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-developers',
  templateUrl: './developers.component.html',
  styleUrls: ['./developers.component.css']
})
export class DevelopersComponent implements OnInit {
  public logDisplay : boolean = false;
  id: string = localStorage.getItem("idAdmin")

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
