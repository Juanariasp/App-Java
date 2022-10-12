package com.usa.reto3d.service;

import com.usa.reto3d.entities.Reservation;
import com.usa.reto3d.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reservation> getAll(){ return reservaRepository.getAll(); }

    public Optional<Reservation> getReserva(int id){ return reservaRepository.getReserva(id); }

    public Reservation save(Reservation r){
        if(r.getIdReservation()==null){
            return reservaRepository.save(r);
        }else {
            Optional<Reservation> e = reservaRepository.getReserva(r.getIdReservation());
            if(e.isPresent()){
                return r;
            }else {
                return reservaRepository.save(r);
            }
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Reservation> e = reservaRepository.getReserva(id);
        if(e.isPresent()){
            reservaRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }


}
