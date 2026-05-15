-- Update destination image URLs to point to local images
-- Ensure you have uploaded the images to the frontend/images folder first.

UPDATE destinations SET image_url = 'images/colombo.jpg' WHERE id = 1;
UPDATE destinations SET image_url = 'images/kandy.jpg' WHERE id = 2;
UPDATE destinations SET image_url = 'images/nuwara-eliya.jpg' WHERE id = 3;
UPDATE destinations SET image_url = 'images/galle.jpg' WHERE id = 4;
UPDATE destinations SET image_url = 'images/ella.jpg' WHERE id = 5;
