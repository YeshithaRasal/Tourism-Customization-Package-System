package com.tourism.model;

import jakarta.persistence.*;

@Entity
@Table(name = "destinations")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL, orphanRemoval = true)
    @com.fasterxml.jackson.annotation.JsonIgnore
    private java.util.List<Hotel> hotels;

    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL, orphanRemoval = true)
    @com.fasterxml.jackson.annotation.JsonIgnore
    private java.util.List<Activity> activities;

    public Destination() {}

    public Destination(Long id, String name, String description, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public static DestinationBuilder builder() {
        return new DestinationBuilder();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public static class DestinationBuilder {
        private Long id;
        private String name;
        private String description;
        private String imageUrl;

        public DestinationBuilder id(Long id) { this.id = id; return this; }
        public DestinationBuilder name(String name) { this.name = name; return this; }
        public DestinationBuilder description(String description) { this.description = description; return this; }
        public DestinationBuilder imageUrl(String imageUrl) { this.imageUrl = imageUrl; return this; }
        public Destination build() {
            return new Destination(id, name, description, imageUrl);
        }
    }
}
