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
import pe.edu.upc.model.entity.Cupon;
import pe.edu.upc.service.CuponService;

@RestController
@RequestMapping("/cupon")
public class CuponController {
    
    @Autowired
    private CuponService cuponService;

    //@ApiOperation("")
    @GetMapping
    public ResponseEntity<List<Cupon>> listar(){
        List<Cupon> cupons= new ArrayList<>();
        cupons=cuponService.listar();
        return new ResponseEntity<List<Cupon>>(cupons,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cupon> listarId(@PathVariable("id") Integer id){
        Optional<Cupon> cupon =cuponService.listId(id);
        if(!cupon.isPresent()){
        throw new ModelNotFoundException("ID:"+ id);
        }

        return new ResponseEntity<Cupon>(cupon.get(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cupon> registrar(@Valid @RequestBody Cupon cupon){
        Cupon cuponNew= new Cupon();
        cuponNew = cuponService.registrar(cupon);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cuponNew.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Cupon> actualizar(@Valid @RequestBody Cupon cupon){
        cuponService.modificar(cupon);
        return new ResponseEntity<Cupon>(HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public void eliminar(@PathVariable Integer id){
        Optional<Cupon> cupon = cuponService.listId(id);
        if(!cupon.isPresent()){
            throw new ModelNotFoundException("ID: "+id);
        } else {
            cuponService.eliminar(id);
        }
    }

}