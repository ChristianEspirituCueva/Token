import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  
  title = 'Token, your finance app';
  //public logDisplay : boolean = true;
  id: string = localStorage.getItem("idAdmin")
  
  activarLog(){
    if (this.id) {
      return false;
    } else {
      return true;
    }
  }

  cerrarsesion(){
    this.id=null;
    localStorage.setItem("idAdmin",null);
  }
}
