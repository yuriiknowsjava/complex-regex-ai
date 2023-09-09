package edu.yuriiknowsjava.complexregexai;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ComplexRegexAiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ComplexRegexAiApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("Writing a complex regex with ChatGTP-4");
    }
}
