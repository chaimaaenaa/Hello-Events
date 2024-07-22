

package com.hello_events.Entites;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private LocalDateTime dateTime;
    private String location;

    @OneToMany(mappedBy = "event")
    private List<Reservation> reservations;
}
