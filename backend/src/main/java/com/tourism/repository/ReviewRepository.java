package com.tourism.repository;

import com.tourism.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT r FROM Review r JOIN r.booking b JOIN b.details d WHERE d.destination.id = :destinationId")
    List<Review> findByDestinationId(@Param("destinationId") Long destinationId);
}
