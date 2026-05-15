CREATE DATABASE IF NOT EXISTS tourism_db;
USE tourism_db;

CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE destinations (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    image_url VARCHAR(255)
);

CREATE TABLE hotels (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    destination_id BIGINT,
    price_per_night DECIMAL(10,2) NOT NULL,
    hotel_type ENUM('budget', 'standard', 'luxury'),
    FOREIGN KEY (destination_id) REFERENCES destinations(id) ON DELETE CASCADE
);

CREATE TABLE activities (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    destination_id BIGINT,
    price DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (destination_id) REFERENCES destinations(id) ON DELETE CASCADE
);

CREATE TABLE events (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    destination_id BIGINT,
    start_date DATE,
    end_date DATE,
    description TEXT,
    is_seasonal BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (destination_id) REFERENCES destinations(id) ON DELETE CASCADE
);

CREATE TABLE bookings (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT,
    total_cost DECIMAL(12,2) NOT NULL,
    status ENUM('pending', 'confirmed', 'cancelled') DEFAULT 'pending',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE booking_details (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    booking_id BIGINT,
    destination_id BIGINT,
    hotel_id BIGINT,
    num_nights INT NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (booking_id) REFERENCES bookings(id) ON DELETE CASCADE,
    FOREIGN KEY (destination_id) REFERENCES destinations(id),
    FOREIGN KEY (hotel_id) REFERENCES hotels(id)
);

CREATE TABLE booking_activities (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    booking_detail_id BIGINT,
    activity_id BIGINT,
    FOREIGN KEY (booking_detail_id) REFERENCES booking_details(id) ON DELETE CASCADE,
    FOREIGN KEY (activity_id) REFERENCES activities(id)
);

CREATE TABLE reviews (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    booking_id BIGINT,
    user_id BIGINT,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    comment TEXT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (booking_id) REFERENCES bookings(id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
