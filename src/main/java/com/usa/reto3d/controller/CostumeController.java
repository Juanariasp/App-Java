package com.usa.reto3d.controller;

import com.usa.reto3d.entities.Costume;
import com.usa.reto3d.service.CostumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Costume")
public class CostumeController {

    @Autowired
    private CostumeService disfrazService;

    @GetMapping("/all")
    public List<Costume> getAll(){ return disfrazService.getAll(); }

    @GetMapping("/{id}")
    public Optional<Costume> getCostume(@PathVariable("id") int id){ return disfrazService.getDisfraz(id); }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Costume save(@RequestBody Costume d){ return disfrazService.save(d); }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Costume update(@RequestBody Costume c){
        return disfrazService.update(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return disfrazService.delete(id);
    }


}
