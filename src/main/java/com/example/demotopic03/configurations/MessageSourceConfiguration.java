package com.example.demotopic03.configurations;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MessageSourceConfiguration {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();

        resourceBundleMessageSource.setBasenames("i18n/messages", "bms");
        resourceBundleMessageSource.setDefaultEncoding("UTF-8");


        return resourceBundleMessageSource;


    }
}
