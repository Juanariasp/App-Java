package com.usa.reto3d.controller;

import com.usa.reto3d.entities.Admins;
import com.usa.reto3d.service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Admin")
public class AdminsController {

    @Autowired
    private AdminsService adminsService;

    @GetMapping("/all")
    public List<Admins> getAll(){return adminsService.getAll();}

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admins save(@RequestBody Admins a){ return adminsService.save(a); }

}
