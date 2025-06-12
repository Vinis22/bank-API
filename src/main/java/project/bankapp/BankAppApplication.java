package project.bankapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "project.bankapp")
public class BankAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(BankAppApplication.class, args);
    }
}