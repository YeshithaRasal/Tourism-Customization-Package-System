-- Destinations
INSERT INTO destinations (id, name, description, image_url) VALUES (1, 'Colombo', 'The commercial capital of Sri Lanka, blending modern skyscrapers with colonial architecture.', 'https://images.unsplash.com/photo-1588258524675-c803bda6749e?auto=format&fit=crop&q=80&w=800');
INSERT INTO destinations (id, name, description, image_url) VALUES (2, 'Kandy', 'The cultural heart of Sri Lanka, home to the Temple of the Tooth and lush botanical gardens.', 'https://images.unsplash.com/photo-1546708973-b339540b5162?auto=format&fit=crop&q=80&w=800');
INSERT INTO destinations (id, name, description, image_url) VALUES (3, 'Nuwara Eliya', 'Little England - known for its cool climate, tea plantations, and scenic beauty.', 'https://images.unsplash.com/photo-1546708973-b339540b5162?auto=format&fit=crop&q=80&w=800');
INSERT INTO destinations (id, name, description, image_url) VALUES (4, 'Galle / Mirissa', 'Famous for its historic Dutch fort and pristine beaches perfect for whale watching.', 'https://images.unsplash.com/photo-1546708973-b339540b5162?auto=format&fit=crop&q=80&w=800');
INSERT INTO destinations (id, name, description, image_url) VALUES (5, 'Ella', 'A mountain town famous for hiking, the Nine Arch Bridge, and breathtaking views.', 'https://images.unsplash.com/photo-1546708973-b339540b5162?auto=format&fit=crop&q=80&w=800');

-- Hotels
-- Colombo
INSERT INTO hotels (name, destination_id, price_per_night, hotel_type) VALUES ('Colombo Granbell', 1, 22000.00, 'luxury');
INSERT INTO hotels (name, destination_id, price_per_night, hotel_type) VALUES ('Shangri-La', 1, 35000.00, 'luxury');
INSERT INTO hotels (name, destination_id, price_per_night, hotel_type) VALUES ('Kingsbury', 1, 28000.00, 'luxury');

-- Galle / Mirissa
INSERT INTO hotels (name, destination_id, price_per_night, hotel_type) VALUES ('Blue Sapphire', 4, 18000.00, 'standard');
INSERT INTO hotels (name, destination_id, price_per_night, hotel_type) VALUES ('Crown', 4, 20000.00, 'standard');
INSERT INTO hotels (name, destination_id, price_per_night, hotel_type) VALUES ('The Nine', 4, 25000.00, 'luxury');

-- Nuwara Eliya
INSERT INTO hotels (name, destination_id, price_per_night, hotel_type) VALUES ('Araliya', 3, 20000.00, 'standard');
INSERT INTO hotels (name, destination_id, price_per_night, hotel_type) VALUES ('Grand', 3, 30000.00, 'luxury');
INSERT INTO hotels (name, destination_id, price_per_night, hotel_type) VALUES ('Summer Hill Breeze', 3, 15000.00, 'budget');

-- Kandy
INSERT INTO hotels (name, destination_id, price_per_night, hotel_type) VALUES ('Queens', 2, 18000.00, 'standard');
INSERT INTO hotels (name, destination_id, price_per_night, hotel_type) VALUES ('Devon', 2, 16000.00, 'standard');
INSERT INTO hotels (name, destination_id, price_per_night, hotel_type) VALUES ('Golden Crown', 2, 24000.00, 'luxury');

-- Ella
INSERT INTO hotels (name, destination_id, price_per_night, hotel_type) VALUES ('98 Acres', 5, 35000.00, 'luxury');
INSERT INTO hotels (name, destination_id, price_per_night, hotel_type) VALUES ('Ella Flower Garden', 5, 18000.00, 'standard');
INSERT INTO hotels (name, destination_id, price_per_night, hotel_type) VALUES ('Ella Gap', 5, 16000.00, 'standard');

-- Activities
-- Colombo
INSERT INTO activities (name, destination_id, price) VALUES ('Lotus Tower Tour', 1, 3000.00);
INSERT INTO activities (name, destination_id, price) VALUES ('Shopping', 1, 5000.00);
INSERT INTO activities (name, destination_id, price) VALUES ('Go Karting', 1, 6000.00);

-- Mirissa / Galle
INSERT INTO activities (name, destination_id, price) VALUES ('Surfing', 4, 6000.00);
INSERT INTO activities (name, destination_id, price) VALUES ('Whale Watching', 4, 12000.00);
INSERT INTO activities (name, destination_id, price) VALUES ('Diving', 4, 15000.00);

-- Nuwara Eliya
INSERT INTO activities (name, destination_id, price) VALUES ('Horton Plains Tour', 3, 8000.00);
INSERT INTO activities (name, destination_id, price) VALUES ('Boat Ride', 3, 3000.00);
INSERT INTO activities (name, destination_id, price) VALUES ('Horse Riding', 3, 4000.00);

-- Kandy
INSERT INTO activities (name, destination_id, price) VALUES ('Hiking', 2, 5000.00);
INSERT INTO activities (name, destination_id, price) VALUES ('Botanical Garden Tour', 2, 3000.00);
INSERT INTO activities (name, destination_id, price) VALUES ('Bird Park Tour', 2, 4000.00);

-- Ella
INSERT INTO activities (name, destination_id, price) VALUES ('Seaplane Tour', 5, 25000.00);
INSERT INTO activities (name, destination_id, price) VALUES ('Hiking', 5, 5000.00);
INSERT INTO activities (name, destination_id, price) VALUES ('Ravana Ella Tour', 5, 4000.00);

-- Events
INSERT INTO events (name, destination_id, start_date, end_date, description, is_seasonal) VALUES ('Kandy Esala Perahera', 2, '2026-07-01', '2026-08-31', 'Traditional Buddhist festival with elegant parades.', TRUE);
INSERT INTO events (name, destination_id, start_date, end_date, description, is_seasonal) VALUES ('Music Festival', 1, '2026-05-01', '2026-05-31', 'Live music performances across Colombo.', TRUE);
INSERT INTO events (name, destination_id, start_date, end_date, description, is_seasonal) VALUES ('Whale Watching Season', 4, '2026-11-01', '2027-04-30', 'Peak time to see Blue Whales in Mirissa.', TRUE);
INSERT INTO events (name, destination_id, start_date, end_date, description, is_seasonal) VALUES ('Tea Harvest Festival', 3, '2026-04-01', '2026-06-30', 'Celebrating the fresh tea harvest in Nuwara Eliya.', TRUE);
