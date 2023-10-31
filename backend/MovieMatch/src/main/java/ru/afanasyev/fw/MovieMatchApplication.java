package ru.afanasyev.fw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ru.afanasyev")
public class MovieMatchApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieMatchApplication.class, args);
    }
}