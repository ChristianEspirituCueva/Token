package pe.edu.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.model.entity.User;
import pe.edu.upc.model.repository.UserRepository;
import pe.edu.upc.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepo;

    @Override
    public User registrar(User t){
        return userRepo.save(t);
    }

    @Override
    public User modificar(User t){
        return userRepo.save(t);
    }

    @Override
    public void eliminar(Integer id) {
        userRepo.deleteById(id);
    }

    @Override
    public Optional<User> listId(Integer id){
        return userRepo.findById(id);
    }

    @Override
    public List<User> listar(){
        return userRepo.findAll();
    }
}