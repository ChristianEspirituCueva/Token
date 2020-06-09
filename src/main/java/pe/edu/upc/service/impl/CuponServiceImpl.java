package pe.edu.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.model.entity.Cupon;
import pe.edu.upc.model.repository.CuponRepository;
import pe.edu.upc.service.CuponService;

@Service
public class CuponServiceImpl implements CuponService{
    
    @Autowired
    CuponRepository cuponRepo;

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