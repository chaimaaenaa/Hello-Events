package com.hello_events.Controleurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hello_events.Entites.Reservation;
import com.hello_events.Services.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public Reservation createReservation(@RequestParam String userEmail,
                                         @RequestParam Long eventId,
                                         @RequestParam int numberOfTickets) {
        return reservationService.createReservation(userEmail, eventId, numberOfTickets);
    }

    
}
