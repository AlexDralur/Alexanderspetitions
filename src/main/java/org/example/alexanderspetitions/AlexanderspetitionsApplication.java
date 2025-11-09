package org.example.alexanderspetitions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class AlexanderspetitionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlexanderspetitionsApplication.class, args);
    }

}
