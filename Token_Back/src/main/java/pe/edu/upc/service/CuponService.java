package pe.edu.upc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.upc.model.entity.Bond;
import pe.edu.upc.model.entity.Cupon;

@Service
public interface CuponService extends CrudService<Cupon>{

    public Bond generateCupons(Bond t);
    
    public List<Cupon> CuponsBond(Bond t);
}