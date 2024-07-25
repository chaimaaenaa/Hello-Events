package com.hello_events.Controleurs;

import com.hello_events.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hello_events.Entites.Reservation;
import com.hello_events.Services.ReservationService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    private UserService userService;

    @PostMapping
    public Reservation createReservation(@RequestParam String userEmail,
                                         @RequestParam Long eventId,
                                         @RequestParam int numberOfTickets,
                                         @RequestParam LocalDateTime lastUpdated) {
        Long userId = userService.getUserIdByEmail(userEmail);
        return reservationService.createReservation(userId, eventId, numberOfTickets, lastUpdated);
    }
    
}
