package com.example.demo.repository;


import com.example.demo.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {

    /**Querry pentru gasire biletelor in functie de zbor */
    @Query("SELECT e FROM Ticket e WHERE e.idZbor = :zbor")
    List<Ticket> findByFlightId(@Param("zbor") Long zbor);
}
