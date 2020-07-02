import { Component, OnInit } from '@angular/core';
import { UserApp} from './../../model/UserApp';
import { UserService} from './../../service/user.service';
import {Router} from '@angular/router'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {  

  /*ngOnInit(): void {
    if (this.id) {
      this.logInDiv=false
    } else {
      this.logInDiv=true;
    }
  }*/

  username: string = '';
  password: string = '';
  message: string= '';

  hide: boolean= true;


  constructor(private userAppS:UserService,private router: Router) { }

  ngOnInit(): void {
  }

  validarcredenciales(){
    let user = new UserApp();
    user.username=this.username;
    user.password=this.password;
    this.userAppS.logIn(user).subscribe(data => {
      if(data['id']==-1){
        this.message="Oh no :( parece que el usuario o la contraseña son incorrectos"
      }else{
        localStorage.setItem('name', data['name']);
        localStorage.setItem('idAdmin', data['id']);
        this.router.navigateByUrl('home');
      }
      console.log(data)
    });
  }

  redirigirRegistro(){

  }

}
