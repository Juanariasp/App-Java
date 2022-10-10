package com.usa.reto3d.controller;


import com.usa.reto3d.entities.Client;
import com.usa.reto3d.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
