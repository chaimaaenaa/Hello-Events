

package com.hello_events.Entites;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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
