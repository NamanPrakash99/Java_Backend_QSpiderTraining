package com.capgemini.Assignment12.service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.Assignment12.entity.Event;
import com.capgemini.Assignment12.repo.EventRepository;


@Service
public class EventService {

    private EventRepository repo;

    public EventService(EventRepository repo){
        this.repo = repo;
    }

    public List<Event> getAllEvents(){
        return repo.findAll();
    }

    public Event getEventById(Long id){
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    public List<Event> getUpcomingEvents(){
        return repo.findByEventDateAfter(LocalDate.now());
    }

    public List<Event> getByType(String type){
        return repo.findByEventType(type);
    }

    public List<Event> searchByTitle(String title){
        return repo.findByTitleContainingIgnoreCase(title);
    }

    public Event createEvent(Event event){

        event.setStatus("SCHEDULED");
        event.setCreatedAt(LocalDateTime.now());

        return repo.save(event);
    }

    public Event updateEvent(Long id, Event updated){

        Event event = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        event.setTitle(updated.getTitle());
        event.setDescription(updated.getDescription());
        event.setEventType(updated.getEventType());
        event.setLocation(updated.getLocation());
        event.setEventDate(updated.getEventDate());
        event.setStartTime(updated.getStartTime());
        event.setEndTime(updated.getEndTime());
        event.setOrganizerName(updated.getOrganizerName());
        event.setContactPhone(updated.getContactPhone());

        event.setUpdatedAt(LocalDateTime.now());

        return repo.save(event);
    }

    public Event cancelEvent(Long id){

        Event event = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        event.setStatus("CANCELLED");

        return repo.save(event);
    }

    public void deleteEvent(Long id){
        repo.deleteById(id);
    }
}