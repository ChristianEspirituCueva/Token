package pe.edu.upc.service;

import org.springframework.stereotype.Service;

import pe.edu.upc.model.entity.Bond;
import pe.edu.upc.model.entity.Cupon;

@Service
public interface CuponService extends CrudService<Cupon>{

    public Bond generateCupons(Bond t);
    
}