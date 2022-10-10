package com.usa.reto3d.repository;

import com.usa.reto3d.entities.Costume;
import com.usa.reto3d.repository.crudRepository.DisfrazCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DisfrazRepository {

    @Autowired
    private DisfrazCrudRepository disfrazCrudRepository;

    public List<Costume> getAll(){ return (List<Costume>) disfrazCrudRepository.findAll();}

    public Costume save(Costume d){ return disfrazCrudRepository.save(d); }

    public void delete(Costume d){ disfrazCrudRepository.delete(d);}

    public Optional<Costume> getDisfraz(int id){ return disfrazCrudRepository.findById(id);}
}
