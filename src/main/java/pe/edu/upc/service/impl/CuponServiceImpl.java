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
        Integer nAnios = t.getTime();
        Integer dxp = 30;
        Integer dxa = 360;
        Integer npxa = dxa/dxp;
        Integer np = npxa*nAnios;
        float impRenta = 0.30f;
        float pPrima = t.getpPrima();
        float pEstruc = t.getpEstruc();
        //float pCol = t.getpCol();
        float pFlot= t.getpFlot();
        float pCavali = t.getpCavali();
        float tea = t.getTea();
        float tep = (float)Math.pow(1+tea,dxp/dxa)-1;
        float d = 0.06f;
        float dp = (float)Math.pow(1+d,dxp/dxa)-1;

        float pextras= pFlot+pCavali+pEstruc;        
        float bono_ind=0.0f;
        float prima=0.0f;

        float iep,bono,interes,escudo;
        double flujoE[] = {};
        double flujoEcE[] = {};
        double flujoB[] = {};
        double flujoA[] = {};
        double flujoAxP[] = {};
        double factorsConv[]= {};

        double flujofE[] = {vComercial + pextras};
        double flujofEcE[] = {flujofE[0]};
        double flujofB[] = {vComercial-(vComercial*(pFlot+pCavali))};

        for(int i=0;i<np;i++){            

            iep = (float)Math.pow(1+0.028,dxp/dxa)-1;
            if((i+1)==1){
                bono=vNominal;
            }else{
                bono=bono_ind;
            }
            bono_ind=bono*(1+iep);
            interes = -1*bono_ind*tep;
            if((i+1)==np){
                prima=(-1)*pPrima*bono_ind;            
            }
            
            escudo=(-1)*interes*impRenta;
            if((i+1)!=np){
                flujoE=ArrayUtils.addAll(flujoE,interes); 
            }else{
                flujoE=ArrayUtils.addAll(flujoE,((-1)*bono_ind)+interes+prima);
            }
            flujoEcE=ArrayUtils.addAll(flujoEcE,escudo+flujoE[i]);
            flujoB=ArrayUtils.addAll(flujoB,(-1)*flujoE[i]);
            flujoA=ArrayUtils.addAll(flujoA,flujoB[i]/((float)Math.pow(1+dp,i+1)));
            flujoAxP=ArrayUtils.addAll(flujoAxP,flujoA[i]*(i+1)*(dxp/dxa));
            factorsConv=ArrayUtils.addAll(factorsConv,flujoA[i]*(i+1)*(1+(i+1)));
            
            Cupon cupon = new Cupon(bono,bono_ind,escudo,prima,flujoE[i],flujoEcE[i],flujoB[i],t);
            cuponRepo.save(cupon);
        }

        double tirE,tceaE,tirEcE,tceaEcE,tirB,treaB;

        flujofE = ArrayUtils.addAll(flujofE,flujoE);
        flujofEcE = ArrayUtils.addAll(flujofEcE,flujoEcE);
        flujofB = ArrayUtils.addAll(flujofB, flujoB);

        tirE = Finance.computeIRR(flujofE, flujofE.length);//una funcion tir de todo el flujo emisor
        tceaE = Math.pow(tirE+1,dxp/dxa)-1;
        tirEcE = Finance.computeIRR(flujofEcE, flujofEcE.length);//funcion tir de todo el flujo emisor con escudo
        tceaEcE = Math.pow(tirEcE +1,dxp/dxa)-1;
        tirB = Finance.computeIRR(flujofB, flujofB.length);//funcion tir de todo el flujo bonista
        treaB = Math.pow(tirB+1,dxp/dxa)-1;
        //Precio Actual= una funcion vna del dp y tofo el flujo bonista
        //VAN= flujo bonista momento 0 + Precio actual
        //duracion= suma de todo el flujo activo x plazo sobre la suma de todo el flujo activo
        //convexidad = suma de toda la convexidad / (potencia(1+dp,2)*suma de todo el flujo act*potencia(dxp/dxa,2))
        //total= duracion + convexidad
        //duracion modificada = duracion / (1 + dp)

        t.setTcea(tceaE);
        t.setTceaEscudo(tceaEcE);
        t.setTreaBonista(treaB);

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
    public void eliminar(Integer id) {
        cuponRepo.deleteById(id);
    }

    @Override
    public Optional<Cupon> listId(Integer id){
        return cuponRepo.findById(id);
    }

    @Override
    public List<Cupon> listar(){
        return cuponRepo.findAll();
    }

}