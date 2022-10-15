package com.usa.reto3d.repository.crudRepository;

import com.usa.reto3d.entities.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {

    @Query("SELECT c.costume, COUNT(c.costume) from Reservation AS c group by c.costume order by COUNT(c.costume) DESC")
    public List<Object[]> countTotalReservationsByCostume();

    //select clientId, count(*) as "total" from reservation group by clientId order by total desc;
    @Query("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) DESC")
    public List<Object[]> countTotalReservationsByClient();

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo );

    public List<Reservation>findAllByStatus(String status);

}
