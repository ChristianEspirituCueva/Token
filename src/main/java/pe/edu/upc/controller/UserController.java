package pe.edu.upc.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pe.edu.upc.exception.ModelNotFoundException;
import pe.edu.upc.model.entity.User;
import pe.edu.upc.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;    

    //@ApiOperation("")
    @GetMapping
    public ResponseEntity<List<User>> listar(){
        List<User> users= new ArrayList<>();
        users=userService.listar();
        return new ResponseEntity<List<User>>(users,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> listarId(@PathVariable("id") Integer id){
        Optional<User> user =userService.listId(id);
        if(!user.isPresent()){
        throw new ModelNotFoundException("ID:"+ id);
        }

        return new ResponseEntity<User>(user.get(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> registrar(@Valid @RequestBody User user){
        User userNew= new User();
        userNew = userService.registrar(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userNew.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<User> actualizar(@Valid @RequestBody User user){
        userService.modificar(user);
        return new ResponseEntity<User>(HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public void eliminar(@PathVariable Integer id){
        Optional<User> user = userService.listId(id);
        if(!user.isPresent()){
            throw new ModelNotFoundException("ID: "+id);
        } else {
            userService.eliminar(id);
        }
    }
}