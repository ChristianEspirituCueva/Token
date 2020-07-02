import {Component, OnInit, ViewChild} from '@angular/core';
import {NgForm} from '@angular/forms';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {MediaMatcher} from '@angular/cdk/layout';
import {Bond} from './../../model/Bond';
import {BondService} from './../../service/bond.service';
import {ChangeDetectorRef, OnDestroy} from '@angular/core';
import {Router} from '@angular/router'

@Component({
  selector: 'app-bono',
  templateUrl: './bono.component.html',
  styleUrls: ['./bono.component.css']
})
export class BonoComponent implements OnInit {
  
  
  vNominal : number = 0.0;
  vComercial: number=0.0;
	nYears:number=0;
	dxp:number=0;
	dxa:number=0;
	impRenta:number=0.0;
	tea:number=0.0;
	tDes:number=0.0;
	pCavali:number=0.0;
	pCol:number=0.0;
	pEstruct: number = 0.0;
	pFlot:number =0.0;
	pPrima:number =0.0;
  method:string ="";
  typeMoney:string="";

  checked = false;
  mobileQuery: MediaQueryList;
  fillerNav = Array.from({length: 50}, (_, i) => `Nav Item ${i + 1}`);
  fillerContent = Array.from({length: 50}, () =>
    `no repitas`);
  // tslint:disable-next-line:variable-name
  private _mobileQueryListener: () => void;

  showFiller = false;
  @ViewChild('dashboard-student', {static: false} )
  dashboardStudentForm: NgForm;
  dataSource = new MatTableDataSource();
  displayedColumns: string[] = ['id', 'state', 'description', 'publicationDate', 'startingDate', 'finishingDate', 'salary'];

  @ViewChild(MatPaginator, {static: true})
  paginator: MatPaginator;

  isEditMode = false;
  constructor(private bondS:BondService,changeDetectorRef: ChangeDetectorRef, media: MediaMatcher,private router: Router) {
    this.mobileQuery = media.matchMedia('(max-width: 600px)');
    this._mobileQueryListener = () => changeDetectorRef.detectChanges();
    this.mobileQuery.addListener(this._mobileQueryListener);
  }

  ngOnInit(): void {
    this.dataSource.paginator = this.paginator;
  }


  // tslint:disable-next-line:use-lifecycle-interface
  ngOnDestroy(): void {
    this.mobileQuery.removeListener(this._mobileQueryListener);
  }

  crearBono(){
    let bono = new Bond();
    bono.vNominal = this.vNominal;
    bono.vComercial = this.vComercial;
    bono.nYears = this.nYears;
    bono.dxp =this.dxp;
    bono.dxa = this.dxa;
    bono.impRenta = this.impRenta;
    bono.tea = this.tea;
    bono.tDes = this.tDes;
    bono.pCavali = this.pCavali;
    bono.pCol = this.pCol;
    bono.pEstruct = this.pEstruct;
    bono.pFlot = this.pFlot;
    bono.pPrima = this.pPrima;
    bono.method = this.method;
    bono.typeMoney = this.typeMoney;
    bono.estado=false;
    let x = localStorage.getItem("idAdmin");
    let y : number  =+ x;
    bono.idcreator=y;

    this.bondS.registrar(bono).subscribe(data => {
      //this.snackBar.open("Usuario registrada.", "Aviso", { duration: 2000 });
      //this.clearControls();
      console.log(data);
      this.router.navigateByUrl('detalleBono/'+data["id"]);
    });

  }

}
