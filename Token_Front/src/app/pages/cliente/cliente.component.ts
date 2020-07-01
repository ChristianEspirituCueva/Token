import { Component, OnInit } from '@angular/core';
import { Client} from './../../model/Client';
import { ClientService} from './../../service/client.service';
import { MatSnackBar} from '@angular/material/snack-bar'
import { FormGroup, Validators, FormControl } from '@angular/forms';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})

export class ClienteComponent implements OnInit {

  nombre: string = "";
  apellido: string = "";
  usuario: string = "";
  password: string ="";
  telefono: number = 0;
  document: string = "";
  ruc: string = "";
  company: string = "";

  constructor(private clienteS: ClientService,private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    
  }

  validacion(){
    if(this.nombre === "" || this.apellido === "" || this.telefono < 0||this.usuario===""||this.password===""){
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

}
