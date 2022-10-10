package com.usa.reto3d.service;

import com.usa.reto3d.entities.Costume;
import com.usa.reto3d.repository.DisfrazRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisfrazService {

    @Autowired
    private DisfrazRepository disfrazRepository;

    public List<Costume> getAll(){ return disfrazRepository.getAll(); }

    public Optional<Costume> getDisfraz(int id){ return disfrazRepository.getDisfraz(id); }

    public Costume save(Costume d){
        if(d.getId()==null){
            return disfrazRepository.save(d);
        }else {
            Optional<Costume> e = disfrazRepository.getDisfraz(d.getId());
            if(e.isPresent()){
                return d;
            }else {
                return disfrazRepository.save(d);
            }
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Costume> e = disfrazRepository.getDisfraz(id);
        if(e.isPresent()){
            disfrazRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }


}
