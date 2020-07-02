import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nosotros',
  templateUrl: './nosotros.component.html',
  styleUrls: ['./nosotros.component.css']
})
export class NosotrosComponent implements OnInit {

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
