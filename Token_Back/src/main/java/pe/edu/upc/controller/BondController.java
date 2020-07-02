package pe.edu.upc.controller;

import java.net.URI;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

//import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONObject;
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
import pe.edu.upc.model.entity.Admin;
import pe.edu.upc.service.BondService;
import pe.edu.upc.service.CuponService;

@RestController
@RequestMapping("api/bono")
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
    public ResponseEntity<Bond> registrar(@RequestBody String bono){
        
        JSONObject js= new JSONObject(bono);       
        Admin user= new Admin();
        user.setid(js.getInt("idcreator"));
        //Date fecEmision = DateUtils.parseDate(js.getString("fecEmision"),new String[] { "yyyy-MM-dd HH:mm:ss", "dd/MM-yyyy" });
        //Date fecliqu = DateUtils.parseDate(js.getString("fecLiqu"),new String[] { "yyyy-MM-dd HH:mm:ss", "dd/MM-yyyy" });
        Bond bonoNew= new Bond(
            user,          
            js.getFloat("vNominal"),
            js.getFloat("vComercial"),
            js.getInt("nYears"),
            js.getInt("dxp"),
            js.getInt("dxa"),
            js.getFloat("impRenta"),
            js.getFloat("pCol"),
            js.getFloat("tDes"),
            js.getFloat("tea"),
            js.getFloat("pPrima"),
            js.getFloat("pEstruct"),
            js.getFloat("pFlot"),
            js.getFloat("pCavali"),
            js.getString("method"),
            //fecEmision,
            //fecliqu,            
            js.getBoolean("estado"),
            js.getString("typeMoney")
            );      
        bonoNew = bondService.registrar(bonoNew);
        bonoNew = cuponservice.generateCupons(bonoNew);
        bondService.results(bonoNew.getId(),bonoNew.getTcea(),bonoNew.getTceaEscudo(),bonoNew.getTreaBonista(),bonoNew.getCPrice(),bonoNew.getVna());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(bonoNew.getId()).toUri();
        return new ResponseEntity<Bond>(bonoNew,HttpStatus.OK);
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