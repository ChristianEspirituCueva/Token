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
import pe.edu.upc.model.entity.Bond;
import pe.edu.upc.service.BondService;
import pe.edu.upc.service.CuponService;

@RestController
@RequestMapping("/bono")
public class BondController {
    
    @Autowired
    private BondService bondService;

    @Autowired
    private CuponService cuponservice;

    //@ApiOperation("")
    @GetMapping
    public ResponseEntity<List<Bond>> listar(){
        List<Bond> bonos= new ArrayList<>();
        bonos=bondService.listar();
        return new ResponseEntity<List<Bond>>(bonos,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Bond> listarId(@PathVariable("id") Integer id){
        Optional<Bond> bono =bondService.listId(id);
        if(!bono.isPresent()){
        throw new ModelNotFoundException("ID:"+ id);
        }

        return new ResponseEntity<Bond>(bono.get(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Bond> registrar(@Valid @RequestBody Bond bono){
        Bond bonoNew= new Bond();
        bonoNew = bondService.registrar(bono);
        bono = cuponservice.generateCupons(bono);
        bondService.results(bono.getId(),bono.getTcea(),bono.getTceaEscudo(),bono.getTreaBonista());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(bonoNew.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Bond> actualizar(@Valid @RequestBody Bond bono){
        bondService.modificar(bono);
        return new ResponseEntity<Bond>(HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public void eliminar(@PathVariable Integer id){
        Optional<Bond> bono = bondService.listId(id);
        if(!bono.isPresent()){
            throw new ModelNotFoundException("ID: "+id);
        } else {
            bondService.eliminar(id);
        }
    }
}