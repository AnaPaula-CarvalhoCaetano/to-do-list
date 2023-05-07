package com.api.todo.list.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.Converter;
import org.modelmapper.AbstractConverter;


@Configuration
public class MyApplicationConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        Converter<String, Boolean> stringToBooleanConverter = new AbstractConverter<String, Boolean>() {
            protected Boolean convert(String source) {
                return "true".equals(source.toLowerCase());
            }
        };
        modelMapper.addConverter(stringToBooleanConverter);

        return modelMapper;
    }
}
