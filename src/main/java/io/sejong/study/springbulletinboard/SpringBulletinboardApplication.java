package io.sejong.study.springbulletinboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class SpringBulletinboardApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBulletinboardApplication.class, args);
  }
}
