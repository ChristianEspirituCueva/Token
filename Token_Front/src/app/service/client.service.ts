import { Injectable } from '@angular/core';
import {HOST} from './../shared/var.constant'
import {HttpClient} from '@angular/common/http'
import {Client} from '../model/Client'

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  url: string = `/api/cliente`;

  constructor(private http: HttpClient) { }

  listar(){
    return this.http.get<Client[]>(this.url);
  }

  listClientForID(id: number){
    return this.http.get<Client>(`${this.url}/${id}`);
  }

  registrar(cliente: Client){
    return this.http.post(this.url,cliente);
  }

  modificar(cliente: Client){
    return this.http.put(this.url,cliente);
  }

  eliminar(id: number){
    return this.http.delete(`${this.url}/${id}`);
  }
}
