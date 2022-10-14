package com.usa.reto3d.service;

import com.usa.reto3d.entities.Client;
import com.usa.reto3d.entities.Message;
import com.usa.reto3d.repository.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MensajeriaService {

    @Autowired
    private MensajeRepository mensajeRepository;

    public List<Message> getAll(){ return mensajeRepository.getAll(); }

    public Optional<Message> getMensaje(int id){ return mensajeRepository.getMensaje(id); }

    public Message save(Message m){
        if(m.getIdMessage()==null){
            return mensajeRepository.save(m);
        }else {
            Optional<Message> e = mensajeRepository.getMensaje((m.getIdMessage()));
            if(e.isPresent()){
                return m;
            }else {
                return mensajeRepository.save(m);
            }
        }
    }

    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> e = mensajeRepository.getMensaje(message.getIdMessage());
            if (e.isPresent()){
                if (message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                if (message.getCostume()!=null){
                    e.get().setCostume(message.getCostume());
                }
                if (message.getClient()!=null){
                    e.get().setClient(message.getClient());
                }
                mensajeRepository.save(e.get());
                return e.get();
            }else {
                return message;
            }
        }else {
            return message;
        }
    }


    public boolean delete(int id){
        boolean flag=false;
        Optional<Message> e = mensajeRepository.getMensaje((id));
        if(e.isPresent()){
            mensajeRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }



}
