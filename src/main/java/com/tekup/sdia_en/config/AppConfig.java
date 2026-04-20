package com.tekup.sdia_en.config;


import com.tekup.sdia_en.Engine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    public Engine engine(){
        return new Engine();
    }
}
