package pe.edu.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.model.entity.UserApp;
import pe.edu.upc.model.repository.UserRepository;
import pe.edu.upc.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepo;

    @Override
    public Optional<UserApp> logIn(String username,String password){
        int i = userRepo.validator(username,password);
        int id;
        if(i==0){
            id=-1;
        }else{
            id = userRepo.logIn(username,password);
        }
        Optional<UserApp> user = userRepo.findById(id);        
        return user;
    }

    @Override
    public UserApp registrar(UserApp t){
        return userRepo.save(t);
    }

    @Override
    public UserApp modificar(UserApp t){
        return userRepo.save(t);
    }

    @Override
    public void eliminar(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public Optional<UserApp> listId(int id){
        return userRepo.findById(id);
    }

    @Override
    public List<UserApp> listar(){
        return userRepo.findAll();
    }
}