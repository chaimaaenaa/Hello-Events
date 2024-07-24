

package com.hello_events.Entites;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.springframework.data.annotation.Id;


import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Event {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDateTime dateTime;
    private String location;
    @OneToMany(mappedBy = "event")
    private List<Reservation> reservations;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
