package com.matriculas_servicio.configuracion;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTc0NDY4NzE4NSwiZXhwIjoxNzQ0NjkwNzg1fQ.tA3taJbhHpGN5Fv9BGr1NTT1WpkJzWaZiicNjF-KT9s";
                template.header("Authorization", token);
            }
        };
    }
}