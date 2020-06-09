package pe.edu.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.model.entity.Admin;
import pe.edu.upc.model.repository.AdminRepository;
import pe.edu.upc.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
    
    @Autowired
    AdminRepository adminRepo;

    @Override
    public Admin registrar(Admin t){
        return adminRepo.save(t);
    }

    @Override
    public Admin modificar(Admin t){
        return adminRepo.save(t);
    }

    @Override
    public void eliminar(Integer id) {
        adminRepo.deleteById(id);
    }

    @Override
    public Optional<Admin> listId(Integer id){
        return adminRepo.findById(id);
    }

    @Override
    public List<Admin> listar(){
        return adminRepo.findAll();
    }
}