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
import pe.edu.upc.model.entity.UserApp;
import pe.edu.upc.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;    

    //@ApiOperation("")
    @GetMapping
    public ResponseEntity<List<UserApp>> listar(){
        List<UserApp> users= new ArrayList<>();
        users=userService.listar();
        return new ResponseEntity<List<UserApp>>(users,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserApp> listarId(@PathVariable("id") Integer id){
        Optional<UserApp> user =userService.listId(id);
        if(!user.isPresent()){
        throw new ModelNotFoundException("ID:"+ id);
        }

        return new ResponseEntity<UserApp>(user.get(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserApp> registrar(@Valid @RequestBody UserApp user){
        UserApp userNew= new UserApp();
        userNew = userService.registrar(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userNew.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<UserApp> actualizar(@Valid @RequestBody UserApp user){
        userService.modificar(user);
        return new ResponseEntity<UserApp>(HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public void eliminar(@PathVariable Integer id){
        Optional<UserApp> user = userService.listId(id);
        if(!user.isPresent()){
            throw new ModelNotFoundException("ID: "+id);
        } else {
            userService.eliminar(id);
        }
    }
}