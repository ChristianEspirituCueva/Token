package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import pe.edu.upc.model.entity.UserApp;

@Service
public interface UserService extends CrudService<UserApp>{
    
    public  Optional<UserApp> logIn(String username,String password);
}