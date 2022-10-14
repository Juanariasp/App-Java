package com.usa.reto3d.controller;

import com.usa.reto3d.entities.Client;
import com.usa.reto3d.entities.Message;
import com.usa.reto3d.service.MensajeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
public class MensajeriaController {

    @Autowired
    private MensajeriaService mensajeriaService;

    @GetMapping("/all")
    public List<Message> getAll(){ return mensajeriaService.getAll(); }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message message) {
        return mensajeriaService.save(message);
    }

    @GetMapping("/{id}")
    public Optional<Message> getCostume(@PathVariable("id") int id){ return mensajeriaService.getMensaje(id); }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message m){
        return mensajeriaService.update(m);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return mensajeriaService.delete(id);
    }


}
