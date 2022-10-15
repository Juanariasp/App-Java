package com.usa.reto3d.service;

import com.usa.reto3d.entities.Reservation;
import com.usa.reto3d.entities.counts.CountClient;
import com.usa.reto3d.entities.counts.CountCostume;
import com.usa.reto3d.entities.counts.StatusAmount;
import com.usa.reto3d.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservaRepository;

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

    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> e = reservaRepository.getReserva(reservation.getIdReservation());
            if (e.isPresent()){
                if (reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getCostume()!=null){
                    e.get().setCostume(reservation.getCostume());
                }
                if (reservation.getClient()!=null){
                    e.get().setClient(reservation.getClient());
                }
                reservaRepository.save(e.get());
                return e.get();
            }else {
                return reservation;
            }
        }else {
            return reservation;
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


    //RETO 5
    public List<CountCostume> getTopCostume(){
        return reservaRepository.getTopCostume();
    }

    public List<CountClient> getTopClients(){
        return reservaRepository.getTopClients();
    }

    public List<Reservation> getReservationsPeriod(String dateA, String dateB){
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date a= new Date();
        Date b=new Date();
        try {
            a = parser.parse(dateA);
            b = parser.parse(dateB);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(a.before(b)){
            return reservaRepository.getReservationPeriod(a,b);
        }else{
            return new ArrayList<>();
        }

    }
    public StatusAmount getReservationsStatusReport(){
        List<Reservation>completed=reservaRepository.getReservationsByStatus("completed");
        List<Reservation>cancelled=reservaRepository.getReservationsByStatus("cancelled");
        return new StatusAmount(completed.size(),cancelled.size());

    }


}
