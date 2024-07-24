package com.hello_events.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hello_events.Entites.Reservation;
import com.hello_events.Repositories.ReservationRepository;

import java.time.LocalDateTime;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation createReservation(String userEmail, Long eventId, int numberOfTickets) {
        Reservation reservation = new Reservation();
        reservation.setUserEmail(userEmail);
        reservation.setEventId(eventId);
        reservation.setNumberOfTickets(numberOfTickets);
        reservation.setReservationTime(LocalDateTime.now());
        reservation.setStatus(Reservation.ReservationStatus.PENDING);
        return reservationRepository.save(reservation);
    }


}
