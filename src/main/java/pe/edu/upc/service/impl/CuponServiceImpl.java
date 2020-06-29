package pe.edu.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.ArrayUtils;

import pe.edu.upc.model.entity.Bond;
import pe.edu.upc.model.entity.Cupon;
import pe.edu.upc.model.repository.CuponRepository;
import pe.edu.upc.service.CuponService;
import pe.edu.upc.utilities.Finance;
import org.apache.poi.ss.formula.functions.FinanceLib;

@Service
public class CuponServiceImpl implements CuponService{
    
    @Autowired
    CuponRepository cuponRepo;

    public Bond generateCupons(Bond t){

        float vNominal = t.getvNominal();
        float vComercial = t.getvComercial();
        int nAnios = t.getNYears();
        int dxp = t.getDxp();
        int dxa = t.getDxA();
        int npxa = dxa/dxp;
        int np = npxa*nAnios;
        float impRenta = t.getImpRenta()/100;
        float pPrima = t.getpPrima()/100;
        float pEstruc = t.getpEstruc()/100;
        float pCol = t.getPCol()/100;
        float pFlot= t.getpFlot()/100;
        float pCavali = t.getpCavali()/100;
        float tea = t.getTea()/100;
        float freq=(float)dxp/(float)dxa;
        float freq_inv=(float)dxa/(float)dxp;
        double tep = (Math.pow(1+tea,freq)-1);
        float d = t.getTDes()/100;
        double dp = (Math.pow(1+d,freq)-1);
        String method =t.getMethod();

        float pextras= -(pFlot+pCavali+pEstruc+pCol)*vComercial;
        float bono_ind=0.0f;
        float prima=0.0f;
        String pg="S";

        float bono;
        double interes,escudo;
        double cuota=0.0;
        double amort=0.0;
        double flujoE[] = {};
        double flujoEcE[] = {};
        double flujoB[] = {};        

        double flujofE[] = {vComercial + pextras};
        double flujofEcE[] = {flujofE[0]};
        double flujofB[] = {-vComercial-(vComercial*(pFlot+pCavali))};

        for(int i=0;i<np;i++){
            
            if((i+1)==1){
                bono=vNominal;
            }else{
                bono=bono_ind;
            }

            bono_ind=bono*(1+0);
            interes = -1*bono_ind*tep;

            if( method.equals("Frances")){                
                if(pg=="T"){
                    cuota=0;
                    amort=0;
                } else if(pg=="P"){
                    cuota=interes;
                    amort=0;
                } else if(pg=="S"){
                    cuota=(-1)*bono_ind*tep/(1-Math.pow(1+tep,(-1)*(np-(i+1)+1)));
                    amort=cuota-interes;
                }                
            } else if(method.equals("Aleman")){                
                if(pg=="T"){
                    cuota=0;
                    amort=0;
                } else if(pg=="P"){
                    cuota=interes;
                    amort=0;
                } else if(pg=="S"){
                    cuota=interes+amort;
                    amort=(-1)*bono_ind/(np-(i+1)+1);
                }
            } else if(method.equals("Americano")){
                if(pg=="T"){
                    cuota=0;                
                } else if(pg=="P"){
                    cuota=interes;                    
                } else if(pg=="S"){
                    cuota=interes+amort;                    
                }
                if(i+1==np){
                    amort=(-1)*bono_ind;
                }else{
                    amort=0;
                }
            }

            if((i+1)==np){
                prima=(-1)*pPrima*bono_ind;            
            }
            
            escudo=(-1)*interes*impRenta;
            
            if((i+1)==np){
                flujoE=ArrayUtils.addAll(flujoE,-bono_ind+cuota+prima);
            }else{
                flujoE=ArrayUtils.addAll(flujoE,cuota);
            }
            flujoEcE=ArrayUtils.addAll(flujoEcE,escudo+flujoE[i]);
            flujoB=ArrayUtils.addAll(flujoB,(-1)*flujoE[i]);            
            
            Cupon cupon = new Cupon(pg,bono,bono_ind,(float)interes,cuota,amort,prima,(float)escudo,
            flujoE[i],flujoEcE[i],flujoB[i],i+1,t);
            cuponRepo.save(cupon);
            cupon=null;
        }

        double tirE,tceaE,tirEcE,tceaEcE,tirB,treaB;
        double Cprice,VNA;

        flujofE = ArrayUtils.addAll(flujofE,flujoE);
        flujofEcE = ArrayUtils.addAll(flujofEcE,flujoEcE);
        flujofB = ArrayUtils.addAll(flujofB, flujoB);

        tirE = Finance.computeIRR(flujofE)/100;//una funcion tir de todo el flujo emisor
        tceaE = Math.pow(tirE+1,freq_inv)-1;
        tirEcE = Finance.computeIRR(flujofEcE)/100;//funcion tir de todo el flujo emisor con escudo
        tceaEcE = Math.pow(tirEcE +1,freq_inv)-1;
        tirB = Finance.computeIRR(flujofB)/100;//funcion tir de todo el flujo bonista
        treaB = Math.pow(tirB+1,freq_inv)-1;
        Cprice = FinanceLib.npv(dp, flujoB);//una funcion vna del dp y tofo el flujo bonista
        VNA = (-vComercial-(vComercial*(pFlot+pCavali))) + Cprice;//flujo bonista momento 0 + Precio actual
        
        t.setTcea(tceaE);
        t.setTceaEscudo(tceaEcE);
        t.setTreaBonista(treaB);
        t.setCPrice(Cprice);
        t.setVna(VNA);

        return t;
    }

    @Override
    public Cupon registrar(Cupon t){
        return cuponRepo.save(t);
    }

    @Override
    public Cupon modificar(Cupon t){
        return cuponRepo.save(t);
    }

    @Override
    public void eliminar(int id) {
        cuponRepo.deleteById(id);
    }

    @Override
    public Optional<Cupon> listId(int id){
        return cuponRepo.findById(id);
    }

    @Override
    public List<Cupon> listar(){
        return cuponRepo.findAll();
    }

}