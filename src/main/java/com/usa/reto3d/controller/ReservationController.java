package com.usa.reto3d.controller;

import com.usa.reto3d.entities.Reservation;
import com.usa.reto3d.entities.counts.CountClient;
import com.usa.reto3d.entities.counts.CountCostume;
import com.usa.reto3d.entities.counts.StatusAmount;
import com.usa.reto3d.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservaService;

    @GetMapping("/all")
    public List<Reservation> getAll(){ return reservaService.getAll(); }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation r){ return reservaService.save(r); }
    @GetMapping("/{id}")
    public Optional<Reservation> getCostume(@PathVariable("id") int id){ return reservaService.getReserva(id); }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation r){
        return reservaService.update(r);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return reservaService.delete(id);
    }


    //RETO 5

    @GetMapping("/report-costue")
    public List<CountCostume> getReservationsReportRoom(){
        return reservaService.getTopCostume();
    }

    @GetMapping("/report-clients")
    public List<CountClient> getReservationsReportClient(){
        return reservaService.getTopClients();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationsReportDates(@PathVariable("dateOne") String dateOne,@PathVariable("dateTwo") String dateTwo){
        return reservaService.getReservationsPeriod(dateOne,dateTwo);
    }
    @GetMapping("/report-dates/amount/{dateOne}/{dateTwo}")
    public Integer getReservationsReportDatesAmount(@PathVariable("dateOne") String dateOne,@PathVariable("dateTwo") String dateTwo){
        return reservaService.getReservationsPeriod(dateOne,dateTwo).size();
    }

    @GetMapping("/report-status")
    public StatusAmount getReservationsStatusReport(){
        return reservaService.getReservationsStatusReport();
    }


}
