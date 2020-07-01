import { Injectable } from '@angular/core';
import {Admin} from '../model/Admin'
import {HOST} from './../shared/var.constant'
import {HttpClient} from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  url: string = `${HOST}/admin`

  constructor(private http: HttpClient) { }

  listar(){
    return this.http.get<Admin[]>(this.url);
  }

  listClientForID(id: number){
    return this.http.get<Admin>(`${this.url}/${id}`);
  }

  registrar(admin: Admin){
    return this.http.post(this.url,admin);
  }

  modificar(admin: Admin){
    return this.http.put(this.url,admin);
  }

  eliminar(id: number){
    return this.http.delete(`${this.url}/${id}`);
  }
}
