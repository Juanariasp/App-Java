package com.usa.reto3d.controller;

import com.usa.reto3d.entities.Costume;
import com.usa.reto3d.service.DisfrazService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Costume")
public class DisfrazController {

    @Autowired
    private DisfrazService disfrazService;

    @GetMapping("/all")
    public List<Costume> getAll(){ return disfrazService.getAll(); }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Costume save(@RequestBody Costume d){ return disfrazService.save(d); }
}
