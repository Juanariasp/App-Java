package com.usa.reto3d.repository;

import com.usa.reto3d.entities.Reservation;
import com.usa.reto3d.repository.crudRepository.ReservaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservaRepository {

    @Autowired
    private ReservaCrudRepository reservaCrudRepository;

    public List<Reservation> getAll(){ return (List<Reservation>) reservaCrudRepository.findAll(); }

    public Reservation save(Reservation r){ return reservaCrudRepository.save(r); }

    public void delete(Reservation r){ reservaCrudRepository.delete(r); }

    public Optional<Reservation> getReserva(int id){ return reservaCrudRepository.findById(id); }
}
