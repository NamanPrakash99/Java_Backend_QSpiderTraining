package com.capgemini.Assignment12.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.Assignment12.entity.Event;


public interface EventRepository extends JpaRepository<Event, Long>{

    List<Event> findByEventType(String eventType);

    List<Event> findByTitleContainingIgnoreCase(String title);

    List<Event> findByEventDateAfter(java.time.LocalDate date);

}
