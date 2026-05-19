package com.tourism;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ImageUpdater implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public ImageUpdater(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Updating destination images...");
        jdbcTemplate.update("UPDATE destinations SET image_url = 'images/colombo.jpg' WHERE id = 1");
        jdbcTemplate.update("UPDATE destinations SET image_url = 'images/kandy.jpg' WHERE id = 2");
        jdbcTemplate.update("UPDATE destinations SET image_url = 'images/nuwara-eliya.jpg' WHERE id = 3");
        jdbcTemplate.update("UPDATE destinations SET image_url = 'images/galle.jpg' WHERE id = 4");
        jdbcTemplate.update("UPDATE destinations SET image_url = 'images/ella.jpg' WHERE id = 5");
        System.out.println("Images updated successfully!");
    }
}
