package com.usa.reto3d.service;

import com.usa.reto3d.entities.Client;
import com.usa.reto3d.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    public List<Client> getAll(){ return clientesRepository.getAll(); }

    public Optional<Client> getCliente(int id){ return clientesRepository.getCliente(id); }

    public Client save(Client c){
        if(c.getIdClient()==null){
            return clientesRepository.save(c);
        }else {
            Optional<Client> e = clientesRepository.getCliente(c.getIdClient());
            if(e.isPresent()){
                return c;
            }else {
                return clientesRepository.save(c);
            }
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Client> e = clientesRepository.getCliente(id);
        if(e.isPresent()){
            clientesRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }



}
