package com.usa.reto3d.service;

import com.usa.reto3d.entities.Admins;
import com.usa.reto3d.repository.AdminsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminsService {

    @Autowired
    private AdminsRepository adminsRepository;

    public List<Admins> getAll(){ return adminsRepository.getAll(); }

    public Optional<Admins> getAdmin(int id){ return adminsRepository.getAdmin(id); }

    public Admins save(Admins a){
        if(a.getIdAdmin()==null){
            return adminsRepository.save(a);
        }else {
            Optional<Admins> e = adminsRepository.getAdmin(a.getIdAdmin());
            if(e.isPresent()){
                return a;
            }else {
                return adminsRepository.save(a);
            }
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Admins> e = adminsRepository.getAdmin(id);
        if(e.isPresent()){
            adminsRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }


}
