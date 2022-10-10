package com.usa.reto3d.service;

import com.usa.reto3d.entities.Category;
import com.usa.reto3d.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Category> getAll(){ return categoriaRepository.getAll(); }

    public Optional<Category> getCategoria(int id){ return categoriaRepository.getCategoria(id); }

    public Category save(Category c){
        if(c.getId()==null){
            return categoriaRepository.save(c);
        }else {
            Optional<Category> e = categoriaRepository.getCategoria(c.getId());
            if(e.isPresent()){
                return c;
            }else {
                return categoriaRepository.save(c);
            }
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Category> e = categoriaRepository.getCategoria(id);
        if(e.isPresent()){
            categoriaRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }

}
