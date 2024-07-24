package com.hello_events.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hello_events.Entites.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
