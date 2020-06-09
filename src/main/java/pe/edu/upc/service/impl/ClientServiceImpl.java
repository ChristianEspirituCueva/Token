package pe.edu.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.model.entity.Client;
import pe.edu.upc.model.repository.ClientRepository;
import pe.edu.upc.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
    
    @Autowired
    ClientRepository clientRepo;

    @Override
    public Client registrar(Client t){
        return clientRepo.save(t);
    }

    @Override
    public Client modificar(Client t){
        return clientRepo.save(t);
    }

    @Override
    public void eliminar(Integer id) {
        clientRepo.deleteById(id);
    }

    @Override
    public Optional<Client> listId(Integer id){
        return clientRepo.findById(id);
    }

    @Override
    public List<Client> listar(){
        return clientRepo.findAll();
    }
}