package br.com.weslei.bender;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.TimeZone;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DuelCardsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DuelCardsApplication.class, args);
    }

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("America/Belem"));
    }

}
