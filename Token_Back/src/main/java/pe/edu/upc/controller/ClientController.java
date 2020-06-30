package pe.edu.upc.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import pe.edu.upc.model.entity.Client;
import pe.edu.upc.model.entity.UserApp;
import pe.edu.upc.service.ClientService;
import pe.edu.upc.service.UserService;

@RestController
@RequestMapping("api/cliente")
public class ClientController {
    @Autowired
    private ClientService clientService;  

    @Autowired
    private UserService userService;

    
    @GetMapping
    public ResponseEntity<List<Client>> listar(){
        List<Client> clients = new ArrayList<>();
        clients=clientService.listar();
        return new ResponseEntity<List<Client>>(clients,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> listarId(@PathVariable("id") Integer id){
        Optional<Client> cliente =clientService.listId(id);
        if(!cliente.isPresent()){
        throw new ModelNotFoundException("ID:"+ id);
        }

        return new ResponseEntity<Client>(cliente.get(),HttpStatus.OK);
    }

    //@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<Client> registrar(@Valid @RequestBody String cliente){
        JSONObject js= new JSONObject(cliente);
        UserApp userNew = new UserApp(
            js.getString("username"),
            js.getString("password"),
            js.getString("name"),
            js.getString("lastName"),
            js.getLong("phone")
        );
        userNew = userService.registrar(userNew);
        Client clientNew = new Client(
            userNew,
            js.getString("document"),
            js.getString("ruc"),
            js.getString("company"),
            userNew.getId()
        );
        clientNew = clientService.registrar(clientNew);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clientNew.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Client> actualizar(@Valid @RequestBody Client cliente){
        clientService.modificar(cliente);
        return new ResponseEntity<Client>(HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public void eliminar(@PathVariable Integer id){
        Optional<Client> cliente = clientService.listId(id);
        if(!cliente.isPresent()){
            throw new ModelNotFoundException("ID: "+id);
        } else {
            clientService.eliminar(id);
        }
    }
}