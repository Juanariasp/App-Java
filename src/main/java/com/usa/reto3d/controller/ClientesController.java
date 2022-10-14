package com.usa.reto3d.controller;


import com.usa.reto3d.entities.Category;
import com.usa.reto3d.entities.Client;
import com.usa.reto3d.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    @GetMapping("/all")
    public List<Client> getAll(){ return clientesService.getAll(); }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client c){ return clientesService.save(c); }

    @GetMapping("/{id}")
    public Optional<Client> getCostume(@PathVariable("id") int id){ return clientesService.getCliente(id); }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client c){
        return clientesService.update(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return clientesService.delete(id);
    }
}
