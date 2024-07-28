package com.bank.utils;

import com.bank.DB.RoleEnum;
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
        if(userRepository.findByUsername("User").isEmpty()) {
            User user1 = new User();
            user1.setUsername("User");
            user1.setPassword((encoder.encode("12345")));
            user1.setROLE(RoleEnum.USER);

            userRepository.save(user1);
        }else {
            System.out.println("User");
        }
        if(userRepository.findByUsername("admin").isEmpty()) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(encoder.encode("12345"));
            admin.setROLE(RoleEnum.ADMIN);

            userRepository.save(admin);
        }else {
            System.out.println("admin");
        }
        if(userRepository.findByUsername("chel").isEmpty()) {
            User chel = new User();
            chel.setUsername("chel");
            chel.setPassword(encoder.encode("12345"));
            chel.setROLE(RoleEnum.ADMIN);

            userRepository.save(chel);
        }else {
            System.out.println("chel");
        }
    }
}
