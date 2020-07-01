import { Injectable } from '@angular/core';
import {Bond} from '../model/Bond'
import {HOST} from './../shared/var.constant'
import {HttpClient} from '@angular/common/http'


@Injectable({
  providedIn: 'root'
})
export class BondService {
  url: string = `${HOST}/admin`

  constructor(private http: HttpClient) { }

  listar(){
    return this.http.get<Bond[]>(this.url);
  }

  listClientForID(id: number){
    return this.http.get<Bond>(`${this.url}/${id}`);
  }

  registrar(bono: Bond){
    return this.http.post(this.url,bono);
  }

  modificar(bono: Bond){
    return this.http.put(this.url,bono);
  }

  eliminar(id: number){
    return this.http.delete(`${this.url}/${id}`);
  }
}
