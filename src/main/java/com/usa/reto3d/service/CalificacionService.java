package com.usa.reto3d.service;

import com.usa.reto3d.entities.Score;
import com.usa.reto3d.repository.CalificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalificacionService {

    @Autowired
    private CalificacionRepository calificacionRepository;

    public List<Score> getAll(){ return calificacionRepository.getAll(); }

    public Optional<Score> getCalificacion(int id){ return calificacionRepository.getCalificacion(id); }

    public Score save(Score c){
        if(c.getIdCalificacion()==null){
            return calificacionRepository.save(c);
        }else {
            Optional<Score> e = calificacionRepository.getCalificacion(c.getIdCalificacion());
            if(e.isPresent()){
                return c;
            }else {
                return calificacionRepository.save(c);
            }
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Score> e = calificacionRepository.getCalificacion(id);
        if(e.isPresent()){
            calificacionRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }



}
