import { Component, OnInit } from '@angular/core';
import { Client} from './../../model/Client';
import { Admin} from './../../model/Admin';
import { ClientService} from './../../service/client.service';
import { AdminService} from './../../service/admin.service';
import { MatSnackBar} from '@angular/material/snack-bar'
import { FormGroup, Validators, FormControl } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  nombre: string = "";
  apellido: string = "";
  usuario: string = "";
  password: string ="";
  telefono: number = 0;
  document: string = "";
  ruc: string = "";
  company: string = "";
  cargo: string="";

  v1: number =0;
  v2:number = 1;
  v3:number = 1;
  v4:number = 1;

  constructor(private clienteS: ClientService,private adminS: AdminService,private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    
  }

  validacion(){
    if(this.nombre === "" || this.apellido === "" || this.telefono <= 0||this.usuario===""||this.password===""){
      return true;
    }

    return false;
  }

  step2(){
    this.v1=1;
    this.v2=0;
  }

  step3(){
    
  }

  validacion1(){

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
  visibilidad(){
    if(this.v1===0){
      return false;
    }else{
      return true;
    }
  }

  visibilidad1(){
    if(this.v2===0){
      return false;
    }else{
      return true;
    }
  }

  visibilidad2(){
    if(this.v3===0){
      return false;
    }else{
      return true;
    }
  }

  visibilidad3(){
    if(this.v4===0){
      return false;
    }else{
      return true;
    }
  }

  clearControls(){
    this.document = "";
    this.ruc = "";
    this.company = "";
    this.nombre = "";
    this.apellido = "";
    this.usuario = "";
    this.telefono = 0;
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
    });
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
  }
}
