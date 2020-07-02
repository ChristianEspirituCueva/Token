import { Component, OnInit } from '@angular/core';
import { Client} from './../../model/Client';
import { Admin} from './../../model/Admin';
import { ClientService} from './../../service/client.service';
import { AdminService} from './../../service/admin.service';
import { MatSnackBar} from '@angular/material/snack-bar'
import { FormGroup, Validators, FormControl } from '@angular/forms';
import {Router} from '@angular/router'

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  public logDisplay : boolean = false;
  id: string = localStorage.getItem("idAdmin")

  /*ngOnInit(): void {
    if (this.id) {
      this.logInDiv=false
    } else {
      this.logInDiv=true;
    }
  }*/


  nombre: string = "";
  apellido: string = "";
  usuario: string = "";
  password: string ="";
  telefono: number = 0;
  document: string = "";
  ruc: string = "";
  company: string = "";
  cargo: string="";

  userPick: string;
  typeUser: string[] = ['Administrador', 'Cliente'];
  code:string;

  v1: boolean = true;
  v2: boolean = false;
  v3: boolean = false;
  v4: boolean = false;
  hide: boolean = true;

  isAdmin: boolean;

  constructor(private clienteS: ClientService,private adminS: AdminService,private snackBar: MatSnackBar,
    private router: Router) { }

  ngOnInit(): void {
    
  }

  validate(){
    if(this.userPick==="Administrador"){
      this.isAdmin=false;
      console.log(this.code);
    }else{
      this.isAdmin=true;
    }
  }

  validacion(){
    if(this.nombre === "" || this.apellido === "" || this.telefono <= 0||this.usuario===""||this.password===""){
      return true;
    }

    return false;
  }  

  validacion1(){
    if(this.userPick==="Administrador" && this.code==="ecpcg"){      
      return false;
    }else if(this.userPick==="Cliente"){
      return false;
    }
    return true;
  }

  step2(){
    this.v1=false;
    this.v2=true;
  }

  step3(){
    if(this.userPick==="Administrador" && this.code==="ecpcg"){
      this.v2=false;
      this.v4=true;
    }else{
      this.v2=false;
      this.v4=true;
    }
  }

  validacion2(){
    if(this.document === "" || this.ruc === "" || this.company===""){
      return true;
    }

    return false;
  }

  validacion3(){
    if(this.cargo === ""){
      return true;
    }

    return false;
  }  

  clearControls(){
    this.document = "";
    this.ruc = "";
    this.company = "";
    this.nombre = "";
    this.apellido = "";
    this.usuario = "";
    this.telefono = 0;
    this.cargo="";
  }

  registrarCliente(){
    let cliente = new Client();

    cliente.document = this.document;
    cliente.ruc = this.ruc;
    cliente.company = this.company;
    cliente.name =this.nombre;
    cliente.lastName = this.apellido;
    cliente.username = this.usuario;
    cliente.phone = this.telefono;
    cliente.password = this.password;

    this.clienteS.registrar(cliente).subscribe(data => {
      this.snackBar.open("Usuario registrada.", "Aviso", { duration: 2000 });
      this.clearControls();
      console.log(data);
    });

    this.router.navigateByUrl('login');
  }

  registrarAdmin(){
    let admin = new Admin();

    admin.cargo = this.cargo;
    admin.name =this.nombre;
    admin.lastName = this.apellido;
    admin.username = this.usuario;
    admin.phone = this.telefono;
    admin.password = this.password;

    this.adminS.registrar(admin).subscribe(data => {
      this.snackBar.open("Usuario registrada.", "Aviso", { duration: 2000 });
      this.clearControls();
    });

    this.router.navigateByUrl('login');
  }
}
