import { Injectable } from '@angular/core';
import {HOST} from './../shared/var.constant'
import {HttpClient} from '@angular/common/http'
import {UserApp} from '../model/UserApp'

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url: string = `/api/user`;

  constructor(private http: HttpClient) { }

  logIn(user: UserApp){
    return this.http.post<number>(`${this.url}/logIn`,user);
  }

  listar(){
    return this.http.get<UserApp[]>(this.url);
  }

  listClientForID(id: number){
    return this.http.get<UserApp>(`${this.url}/${id}`);
  }

  registrar(user: UserApp){
    return this.http.post(this.url,user);
  }

  modificar(user: UserApp){
    return this.http.put(this.url,user);
  }

  eliminar(id: number){
    return this.http.delete(`${this.url}/${id}`);
  }
}
