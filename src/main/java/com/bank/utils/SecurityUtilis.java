package com.bank.utils;

import com.bank.DB.User;
import com.bank.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtilis implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(5);
        User user1 = new User();
        user1.setName("User");
        user1.setPassword((encoder.encode("12345")));
        user1.setROLE("USER");

        userRepository.save(user1);

        User admin = new User();
        admin.setName("admin");
        admin.setPassword(encoder.encode("12345"));
        admin.setROLE("ADMIN");

        userRepository.save(admin);
    }
}
