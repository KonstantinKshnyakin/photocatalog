package com.example.photocatalog.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class AppConfig {

    @Value("${api.version}")
    private static String apiVersion;

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper om = new ObjectMapper();
        om.setDateFormat(new SimpleDateFormat("dd-MM-yyyy"));
        return om;
    }

    @Bean
    public ErrorAttributes errorAttributes() {
        return new PhotoCatalogErrorAttributes(apiVersion);
    }
}
