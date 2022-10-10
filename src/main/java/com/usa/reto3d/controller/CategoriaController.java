package com.usa.reto3d.controller;


import com.usa.reto3d.entities.Category;
import com.usa.reto3d.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Category")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/all")
    public List<Category> getAll(){ return categoriaService.getAll(); }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category c){ return categoriaService.save(c); }
}
