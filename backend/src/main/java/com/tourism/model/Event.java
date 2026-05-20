package com.tourism.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "is_seasonal")
    private boolean seasonal;

    public Event() {}

    public Event(Long id, String name, Destination destination, LocalDate startDate, LocalDate endDate, String description, boolean seasonal) {
        this.id = id;
        this.name = name;
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.seasonal = seasonal;
    }

    public static EventBuilder builder() {
        return new EventBuilder();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Destination getDestination() { return destination; }
    public void setDestination(Destination destination) { this.destination = destination; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public boolean isSeasonal() { return seasonal; }
    public void setSeasonal(boolean seasonal) { this.seasonal = seasonal; }

    public static class EventBuilder {
        private String name;
        private Destination destination;
        private LocalDate startDate;
        private LocalDate endDate;
        private String description;
        private boolean seasonal;

        public EventBuilder name(String name) { this.name = name; return this; }
        public EventBuilder destination(Destination destination) { this.destination = destination; return this; }
        public EventBuilder startDate(LocalDate startDate) { this.startDate = startDate; return this; }
        public EventBuilder endDate(LocalDate endDate) { this.endDate = endDate; return this; }
        public EventBuilder description(String description) { this.description = description; return this; }
        public EventBuilder seasonal(boolean seasonal) { this.seasonal = seasonal; return this; }
        public Event build() {
            return new Event(null, name, destination, startDate, endDate, description, seasonal);
        }
    }
}
