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
import pe.edu.upc.model.entity.Client;
import pe.edu.upc.service.ClientService;

@RestController
@RequestMapping("/cliente")
public class ClientController {
    @Autowired
    private ClientService clientService;    

    //@ApiOperation("")
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

    @PostMapping
    public ResponseEntity<Client> registrar(@Valid @RequestBody Client cliente){
        Client clientNew = new Client();
        clientNew = clientService.registrar(cliente);
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