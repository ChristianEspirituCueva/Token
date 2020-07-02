import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cupon} from '../model/Cupon'

@Injectable({
  providedIn: 'root'
})
export class CuponService {

  url: string = `/api/cupon`;

  constructor(private http: HttpClient) { }

  listar(){
    return this.http.get<Cupon[]>(this.url);
  }

  listCuponForID(id: number){
    return this.http.get<Cupon[]>(`${this.url}/${id}`);
  }

  registrar(cupon: Cupon){
    return this.http.post(this.url,cupon);
  }

  modificar(cupon: Cupon){
    return this.http.put(this.url,cupon);
  }

  eliminar(id: number){
    return this.http.delete(`${this.url}/${id}`);
  }
}