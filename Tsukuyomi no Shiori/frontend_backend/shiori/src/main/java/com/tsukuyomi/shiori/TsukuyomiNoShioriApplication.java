package com.tsukuyomi.shiori;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TsukuyomiNoShioriApplication {

    public static void main(String[] args) {
        SpringApplication.run(TsukuyomiNoShioriApplication.class, args);
    }
}