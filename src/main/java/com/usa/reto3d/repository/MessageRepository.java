package com.usa.reto3d.repository;

import com.usa.reto3d.entities.Message;
import com.usa.reto3d.repository.crudRepository.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository mensajeCrudRepository;

    public List<Message> getAll(){ return (List<Message>) mensajeCrudRepository.findAll(); }

    public Message save(Message m){ return mensajeCrudRepository.save(m); }

    public void delete(Message m){ mensajeCrudRepository.delete(m);}

    public Optional<Message> getMensaje(int id){ return mensajeCrudRepository.findById(id);}
}
