package com.usa.reto3d.repository;

import com.usa.reto3d.entities.Client;
import com.usa.reto3d.entities.Costume;
import com.usa.reto3d.entities.Reservation;
import com.usa.reto3d.entities.counts.CountClient;
import com.usa.reto3d.entities.counts.CountCostume;
import com.usa.reto3d.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservaCrudRepository;

    public List<Reservation> getAll(){ return (List<Reservation>) reservaCrudRepository.findAll(); }

    public Reservation save(Reservation r){ return reservaCrudRepository.save(r); }

    public void delete(Reservation r){ reservaCrudRepository.delete(r); }

    public Optional<Reservation> getReserva(int id){ return reservaCrudRepository.findById(id); }


    public  List<CountCostume> getTopCostume(){
        List<CountCostume>res=new ArrayList<>();
        List<Object[]>report=reservaCrudRepository.countTotalReservationsByCostume();
        for(int i=0;i<report.size();i++){
            res.add(new CountCostume((Long)report.get(i)[1],(Costume) report.get(i)[0]));
        }
        return res;
    }


    public  List<CountClient> getTopClients(){
        List<CountClient>res=new ArrayList<>();
        List<Object[]>report=reservaCrudRepository.countTotalReservationsByClient();
        for(int i=0;i<report.size();i++){
            res.add(new CountClient((Long)report.get(i)[1],(Client) report.get(i)[0]));
        }
        return res;
    }

    public List<Reservation> getReservationPeriod(Date a, Date b){
        return reservaCrudRepository.findAllByStartDateAfterAndStartDateBefore(a,b);
    }

    public List<Reservation> getReservationsByStatus(String status){
        return reservaCrudRepository.findAllByStatus(status);
    }

}
