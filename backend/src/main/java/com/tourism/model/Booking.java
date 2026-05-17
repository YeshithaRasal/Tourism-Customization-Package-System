package com.tourism.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "total_cost", nullable = false)
    private BigDecimal totalCost;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<BookingDetail> details = new ArrayList<>();

    public enum BookingStatus {
        pending, confirmed, cancelled
    }

    public Booking() {}

    public static BookingBuilder builder() {
        return new BookingBuilder();
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        if (status == null) status = BookingStatus.pending;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public BigDecimal getTotalCost() { return totalCost; }
    public void setTotalCost(BigDecimal totalCost) { this.totalCost = totalCost; }
    public BookingStatus getStatus() { return status; }
    public void setStatus(BookingStatus status) { this.status = status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public List<BookingDetail> getDetails() { return details; }
    public void setDetails(List<BookingDetail> details) { this.details = details; }

    public static class BookingBuilder {
        private User user;
        private BigDecimal totalCost;
        private BookingStatus status;
        private List<BookingDetail> details = new ArrayList<>();

        public BookingBuilder user(User user) { this.user = user; return this; }
        public BookingBuilder totalCost(BigDecimal totalCost) { this.totalCost = totalCost; return this; }
        public BookingBuilder status(BookingStatus status) { this.status = status; return this; }
        public BookingBuilder details(List<BookingDetail> details) { this.details = details; return this; }
        public Booking build() {
            Booking booking = new Booking();
            booking.setUser(user);
            booking.setTotalCost(totalCost);
            booking.setStatus(status);
            booking.setDetails(details);
            return booking;
        }
    }
}
