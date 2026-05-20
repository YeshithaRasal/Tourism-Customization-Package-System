package com.tourism.dto;

import java.util.List;

public class BookingRequest {
    private List<BookingItemRequest> items;

    public List<BookingItemRequest> getItems() { return items; }
    public void setItems(List<BookingItemRequest> items) { this.items = items; }

    public static class BookingItemRequest {
        private Long destinationId;
        private Long hotelId;
        private int numNights;
        private List<Long> activityIds;

        public Long getDestinationId() { return destinationId; }
        public void setDestinationId(Long destinationId) { this.destinationId = destinationId; }
        public Long getHotelId() { return hotelId; }
        public void setHotelId(Long hotelId) { this.hotelId = hotelId; }
        public int getNumNights() { return numNights; }
        public void setNumNights(int numNights) { this.numNights = numNights; }
        public List<Long> getActivityIds() { return activityIds; }
        public void setActivityIds(List<Long> activityIds) { this.activityIds = activityIds; }
    }
}
