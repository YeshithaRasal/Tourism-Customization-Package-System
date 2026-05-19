package com.tourism.controller;

import com.tourism.model.Hotel;
import com.tourism.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    com.tourism.repository.DestinationRepository destinationRepository;

    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @GetMapping("/id/{id}")
    public Hotel getHotelById(@PathVariable Long id) {
        return hotelRepository.findById(id).orElseThrow(() -> new RuntimeException("Hotel not found"));
    }

    @GetMapping("/destination/{destinationId}")
    public List<Hotel> getHotelsByDestination(@PathVariable Long destinationId) {
        return hotelRepository.findByDestinationId(destinationId);
    }

    @PostMapping
    public Hotel createHotel(@RequestBody Hotel hotel) {
        if (hotel.getDestination() != null && hotel.getDestination().getId() != null) {
            hotel.setDestination(destinationRepository.findById(hotel.getDestination().getId())
                    .orElseThrow(() -> new RuntimeException("Destination not found")));
        }
        return hotelRepository.save(hotel);
    }

    @PutMapping("/{id}")
    public Hotel updateHotel(@PathVariable Long id, @RequestBody Hotel hotelDetails) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new RuntimeException("Hotel not found"));
        hotel.setName(hotelDetails.getName());
        if (hotelDetails.getDestination() != null && hotelDetails.getDestination().getId() != null) {
            hotel.setDestination(destinationRepository.findById(hotelDetails.getDestination().getId())
                    .orElseThrow(() -> new RuntimeException("Destination not found")));
        }
        hotel.setPricePerNight(hotelDetails.getPricePerNight());
        hotel.setHotelType(hotelDetails.getHotelType());
        hotel.setImageUrl(hotelDetails.getImageUrl());
        return hotelRepository.save(hotel);
    }

    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable Long id) {
        hotelRepository.deleteById(id);
    }
}
