

package com.hello_events.Repositories;
import com.hello_events.Entites.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
