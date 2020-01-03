package org.catstones.springcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * SpringCat Spring Boot Application
 *
 * @author An Nyeong
 */
@SpringBootApplication
@EnableJpaAuditing
public class SpringCatApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCatApplication.class, args);
    }
}
