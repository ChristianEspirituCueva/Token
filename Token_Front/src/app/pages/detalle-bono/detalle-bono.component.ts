import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { CuponService } from '../../service/cupon.service'
import { Cupon } from 'src/app/model/Cupon';


@Component({
  selector: 'app-detalle-bono',
  templateUrl: './detalle-bono.component.html',
  styleUrls: ['./detalle-bono.component.css']
})
export class DetalleBonoComponent implements OnInit {   

  idCupon: number;
  dataSource: Cupon[];
  vNominal: number;
  method: string;
  tceaEscudo:number;
  tcea: number;
  treaBonista: number;
  vna: number;
  typeMoney: string;
  cprice: number;

  
  constructor(private rutaActiva: ActivatedRoute, private cuponS: CuponService) { }

  ngOnInit(): void {
    this.idCupon= this.rutaActiva.snapshot.params.id;
    this.cuponS.listCuponForID(this.idCupon).subscribe(data => {      
      console.log(data);
      this.dataSource=data;
      this.vNominal = data[0].bond.vNominal;
      this.method = data[0].bond.method;
      this.tceaEscudo =data[0].bond.tceaEscudo*-1*100;
      this.tcea = data[0].bond.tcea*-1*100;
      this.treaBonista = data[0].bond.treaBonista*-1*100;
      this.vna = data[0].bond.vna*-1;
      this.typeMoney = data[0].bond.typeMoney;
      this.cprice =data[0].bond.cprice;
    });
    console.log(this.dataSource);
  }
}
