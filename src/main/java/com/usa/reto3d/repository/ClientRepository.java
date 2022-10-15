package com.usa.reto3d.repository;

import com.usa.reto3d.entities.Client;
import com.usa.reto3d.repository.crudRepository.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientesCrudRepository;

    public List<Client> getAll(){ return (List<Client>) clientesCrudRepository.findAll(); }

    public Client save(Client c){ return clientesCrudRepository.save(c); }

    public void delete(Client c){ clientesCrudRepository.delete(c);}

    public Optional<Client> getCliente(int id){ return clientesCrudRepository.findById(id);}
}
