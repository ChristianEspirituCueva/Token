package pe.edu.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.model.entity.Bond;
import pe.edu.upc.model.repository.BondRepository;
import pe.edu.upc.service.BondService;

@Service
public class BondServiceImpl implements BondService{
    @Autowired
    BondRepository bondRepo;

    @Override
    public void results(Integer id,double tcea,double tcea_escudo,double trea_bonista,double cPrice,double vna){
        bondRepo.updateBondResults(id,tcea, tcea_escudo, trea_bonista,cPrice,vna);
    }

    @Override
    public Bond registrar(Bond t){
        return bondRepo.save(t);
    }

    @Override
    public Bond modificar(Bond t){
        return bondRepo.save(t);
    }

    @Override
    public void eliminar(Integer id) {
        bondRepo.deleteById(id);
    }

    @Override
    public Optional<Bond> listId(Integer id){
        return bondRepo.findById(id);
    }

    @Override
    public List<Bond> listar(){
        return bondRepo.findAll();
    }
}