package com.usa.reto3d.controller;


import com.usa.reto3d.entities.Category;
import com.usa.reto3d.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {

    @Autowired
    private CategoryService categoriaService;

    @GetMapping("/all")
    public List<Category> getAll(){ return categoriaService.getAll(); }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category c){ return categoriaService.save(c); }

    @GetMapping("/{id}")
    public Optional<Category> getCostume(@PathVariable("id") int id){ return categoriaService.getCategoria(id); }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category c){
        return categoriaService.update(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return categoriaService.delete(id);
    }
}
