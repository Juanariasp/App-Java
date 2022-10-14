package com.usa.reto3d.controller;

import com.usa.reto3d.entities.Admins;
import com.usa.reto3d.entities.Score;
import com.usa.reto3d.service.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
public class CalificacionController {

    @Autowired
    private CalificacionService calificacionService;

    @GetMapping("/all")
    public List<Score> getAll(){ return calificacionService.getAll(); }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score c){ return calificacionService.save(c);}

    @GetMapping("/{id}")
    public Optional<Score> getCostume(@PathVariable("id") int id){ return calificacionService.getCalificacion(id); }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score update(@RequestBody Score s){
        return calificacionService.update(s);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return calificacionService.delete(id);
    }
}
