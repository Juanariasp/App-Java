package com.usa.reto3d.repository;

import com.usa.reto3d.entities.Score;
import com.usa.reto3d.repository.crudRepository.CalificacionCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CalificacionRepository {

    @Autowired
    private CalificacionCrudRepository calificacionCrudRepository;

    public List<Score> getAll(){
        return (List<Score>) calificacionCrudRepository.findAll();
    }

    public Score save(Score c){
        return calificacionCrudRepository.save(c);
    }

    public void delete(Score c){
        calificacionCrudRepository.delete(c);
    }

    public Optional<Score> getCalificacion(int id){
        return calificacionCrudRepository.findById(id);
    }

}
