package com.example.demotopic03.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@PropertySource("classpath:/bms.properties") //job leang
public class ResourceHandlerConfiguration implements WebMvcConfigurer {

    @Value("${file.client.path}")
    private String CLIENT_PATH;

    @Value("${file.server.path}")
    private String SERVER_PATH;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(CLIENT_PATH+"**").addResourceLocations("file:" + SERVER_PATH);
    }



}
