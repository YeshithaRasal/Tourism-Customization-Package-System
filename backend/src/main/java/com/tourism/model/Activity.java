package com.tourism.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;

    @Column(nullable = false)
    private BigDecimal price;

    public Activity() {}

    public Activity(Long id, String name, Destination destination, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.destination = destination;
        this.price = price;
    }

    public static ActivityBuilder builder() {
        return new ActivityBuilder();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Destination getDestination() { return destination; }
    public void setDestination(Destination destination) { this.destination = destination; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public static class ActivityBuilder {
        private String name;
        private Destination destination;
        private BigDecimal price;

        public ActivityBuilder name(String name) { this.name = name; return this; }
        public ActivityBuilder destination(Destination destination) { this.destination = destination; return this; }
        public ActivityBuilder price(BigDecimal price) { this.price = price; return this; }
        public Activity build() {
            return new Activity(null, name, destination, price);
        }
    }
}