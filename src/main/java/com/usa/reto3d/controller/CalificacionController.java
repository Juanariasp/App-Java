package com.usa.reto3d.controller;

import com.usa.reto3d.entities.Score;
import com.usa.reto3d.service.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
