package com.tourism.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;

    @Column(name = "price_per_night", nullable = false)
    private BigDecimal pricePerNight;

    @Enumerated(EnumType.STRING)
    @Column(name = "hotel_type")
    private HotelType hotelType;

    public enum HotelType {
        budget, standard, luxury
    }

    public Hotel() {}

    public Hotel(Long id, String name, String imageUrl, Destination destination, BigDecimal pricePerNight, HotelType hotelType) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.destination = destination;
        this.pricePerNight = pricePerNight;
        this.hotelType = hotelType;
    }

    public static HotelBuilder builder() {
        return new HotelBuilder();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public Destination getDestination() { return destination; }
    public void setDestination(Destination destination) { this.destination = destination; }
    public BigDecimal getPricePerNight() { return pricePerNight; }
    public void setPricePerNight(BigDecimal pricePerNight) { this.pricePerNight = pricePerNight; }
    public HotelType getHotelType() { return hotelType; }
    public void setHotelType(HotelType hotelType) { this.hotelType = hotelType; }

    public static class HotelBuilder {
        private String name;
        private String imageUrl;
        private Destination destination;
        private BigDecimal pricePerNight;
        private HotelType hotelType;

        public HotelBuilder name(String name) { this.name = name; return this; }
        public HotelBuilder imageUrl(String imageUrl) { this.imageUrl = imageUrl; return this; }
        public HotelBuilder destination(Destination destination) { this.destination = destination; return this; }
        public HotelBuilder pricePerNight(BigDecimal pricePerNight) { this.pricePerNight = pricePerNight; return this; }
        public HotelBuilder hotelType(HotelType hotelType) { this.hotelType = hotelType; return this; }
        public Hotel build() {
            return new Hotel(null, name, imageUrl, destination, pricePerNight, hotelType);
        }
    }
}
