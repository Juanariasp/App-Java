package com.usa.reto3d.controller;

import com.usa.reto3d.entities.Message;
import com.usa.reto3d.service.MensajeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


}
