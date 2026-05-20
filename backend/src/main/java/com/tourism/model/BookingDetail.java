package com.tourism.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "booking_details")
public class BookingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    @com.fasterxml.jackson.annotation.JsonIgnore
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @Column(name = "num_nights", nullable = false)
    private int numNights;

    @Column(nullable = false)
    private BigDecimal subtotal;

    @ManyToMany
    @JoinTable(
            name = "booking_activities",
            joinColumns = @JoinColumn(name = "booking_detail_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id")
    )
    private List<Activity> activities;

    public BookingDetail() {}

    public static BookingDetailBuilder builder() {
        return new BookingDetailBuilder();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Booking getBooking() { return booking; }
    public void setBooking(Booking booking) { this.booking = booking; }
    public Destination getDestination() { return destination; }
    public void setDestination(Destination destination) { this.destination = destination; }
    public Hotel getHotel() { return hotel; }
    public void setHotel(Hotel hotel) { this.hotel = hotel; }
    public int getNumNights() { return numNights; }
    public void setNumNights(int numNights) { this.numNights = numNights; }
    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
    public List<Activity> getActivities() { return activities; }
    public void setActivities(List<Activity> activities) { this.activities = activities; }

    public static class BookingDetailBuilder {
        private Booking booking;
        private Destination destination;
        private Hotel hotel;
        private int numNights;
        private BigDecimal subtotal;
        private List<Activity> activities;

        public BookingDetailBuilder booking(Booking booking) { this.booking = booking; return this; }
        public BookingDetailBuilder destination(Destination destination) { this.destination = destination; return this; }
        public BookingDetailBuilder hotel(Hotel hotel) { this.hotel = hotel; return this; }
        public BookingDetailBuilder numNights(int numNights) { this.numNights = numNights; return this; }
        public BookingDetailBuilder subtotal(BigDecimal subtotal) { this.subtotal = subtotal; return this; }
        public BookingDetailBuilder activities(List<Activity> activities) { this.activities = activities; return this; }
        public BookingDetail build() {
            BookingDetail detail = new BookingDetail();
            detail.setBooking(booking);
            detail.setDestination(destination);
            detail.setHotel(hotel);
            detail.setNumNights(numNights);
            detail.setSubtotal(subtotal);
            detail.setActivities(activities);
            return detail;
        }
    }
}