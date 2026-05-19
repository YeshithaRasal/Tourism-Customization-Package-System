package com.tourism.service;

import com.tourism.dto.BookingRequest;
import com.tourism.model.*;
import com.tourism.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    DestinationRepository destinationRepository;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    ActivityRepository activityRepository;

    @Transactional
    public Booking createBooking(BookingRequest request, User user) {
        Booking booking = Booking.builder()
                .user(user)
                .totalCost(BigDecimal.ZERO)
                .status(Booking.BookingStatus.pending)
                .details(new ArrayList<>())
                .build();

        BigDecimal grandTotal = BigDecimal.ZERO;

        for (BookingRequest.BookingItemRequest item : request.getItems()) {
            Destination destination = destinationRepository.findById(item.getDestinationId())
                    .orElseThrow(() -> new RuntimeException("Destination not found"));
            Hotel hotel = hotelRepository.findById(item.getHotelId())
                    .orElseThrow(() -> new RuntimeException("Hotel not found"));

            BigDecimal subtotal = hotel.getPricePerNight().multiply(new BigDecimal(item.getNumNights()));

            List<Activity> activities = new ArrayList<>();
            for (Long activityId : item.getActivityIds()) {
                Activity activity = activityRepository.findById(activityId)
                        .orElseThrow(() -> new RuntimeException("Activity not found"));
                activities.add(activity);
                subtotal = subtotal.add(activity.getPrice());
            }

            BookingDetail detail = BookingDetail.builder()
                    .booking(booking)
                    .destination(destination)
                    .hotel(hotel)
                    .numNights(item.getNumNights())
                    .subtotal(subtotal)
                    .activities(activities)
                    .build();

            booking.getDetails().add(detail);
            grandTotal = grandTotal.add(subtotal);
        }

        booking.setTotalCost(grandTotal);
        return bookingRepository.save(booking);
    }

    public List<Booking> getBookingsByUser(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public Booking updateStatus(Long id, Booking.BookingStatus status) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setStatus(status);
        return bookingRepository.save(booking);
    }
}
