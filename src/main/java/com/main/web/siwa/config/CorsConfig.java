package com.main.web.siwa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    WebMvcConfigurer configurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOriginPatterns("http://localhost:5173/")
//                        .allowedOriginPatterns("http://192.168.0.60:5173/")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "UPDATE");
            }
        };
    }
}
