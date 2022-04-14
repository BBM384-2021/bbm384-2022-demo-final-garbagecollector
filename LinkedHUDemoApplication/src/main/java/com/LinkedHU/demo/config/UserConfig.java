package com.LinkedHU.demo.config;

import com.LinkedHU.demo.model.User;
import com.LinkedHU.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner clr (UserRepository userRepository){
        return args -> {
          User admin = new User(
                    "Admin",
                    "Admin",
                    "admin@linkedHU.com",
                    true
            );
          userRepository.save(admin);
        };
    }
}
