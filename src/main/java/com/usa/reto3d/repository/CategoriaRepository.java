package com.usa.reto3d.repository;

import com.usa.reto3d.entities.Category;
import com.usa.reto3d.repository.crudRepository.CategoriasCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepository {

    @Autowired
    private CategoriasCrudRepository categoriasCrudRepository;

    public List<Category> getAll(){ return (List<Category>) categoriasCrudRepository.findAll(); }

    public Category save(Category c){ return categoriasCrudRepository.save(c); }

    public void delete(Category c){ categoriasCrudRepository.delete(c);}

    public Optional<Category> getCategoria(int id){
        return categoriasCrudRepository.findById(id);
    }
}
