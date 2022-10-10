package com.usa.reto3d.controller;

import com.usa.reto3d.entities.Reservation;
import com.usa.reto3d.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/all")
    public List<Reservation> getAll(){ return reservaService.getAll(); }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation r){ return reservaService.save(r); }
}
