export class Cupon{
    id: number;
    bono: number;
    bonoInd: number;
    interes: number;
    cuota: number;
    amort: number;
    prima: number;
    escudo: number;
    flujoE: number;
    flujoEcE: number;
    flujoB: number;
    ncupon: number;
    bond: {
        vNominal: number;
        method: string;
        tceaEscudo:number;
        tcea: number;
        treaBonista: number;
        vna: number;
        typeMoney: string;
        cprice: number;
    }
}