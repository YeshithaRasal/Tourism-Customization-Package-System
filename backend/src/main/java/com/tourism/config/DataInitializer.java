package com.tourism.config;

import com.tourism.model.User;
import com.tourism.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        userRepository.findByEmail("admin@travel.com").ifPresentOrElse(
                admin -> {
                    admin.setRole("ROLE_ADMIN");
                    admin.setPassword(encoder.encode("admin123"));
                    userRepository.save(admin);
                    System.out.println(">>> ADMIN SYNC: admin@travel.com / admin123 (ROLE_ADMIN)");
                },
                () -> {
                    User admin = new User();
                    admin.setName("System Administrator");
                    admin.setEmail("admin@travel.com");
                    admin.setPassword(encoder.encode("admin123"));
                    admin.setRole("ROLE_ADMIN");
                    userRepository.save(admin);
                    System.out.println(">>> ADMIN CREATED: admin@travel.com / admin123 (ROLE_ADMIN)");
                }
        );
    }
}
