package com.example.demotopic03;

import com.example.demotopic03.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoTopic03Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoTopic03Application.class, args);

        UserRepository userRepository = context.getBean(UserRepository.class);

        System.out.println(userRepository.loadUserByUsername("thearoth"));


        PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);


        String passwordEncoded = passwordEncoder.encode("ehan");

        System.out.println(passwordEncoded);


    }
}
