// src/main/java/com/hello-events/model/User.java

package com.hello_events.Entites;


import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations;
}
