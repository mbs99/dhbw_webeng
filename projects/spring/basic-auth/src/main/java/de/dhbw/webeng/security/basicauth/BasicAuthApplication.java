package de.dhbw.webeng.security.basicauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BasicAuthApplication {

  public static void main(String[] args) {
    SpringApplication.run(BasicAuthApplication.class, args);
  }
}
