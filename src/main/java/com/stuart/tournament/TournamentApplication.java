package com.stuart.tournament;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TournamentApplication {

    public static void main(String[] args) {
        SpringApplication.run(TournamentApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
//        mapper.getConfiguration().set
//        mapper.addMappings(trackPropertyMap);

        return mapper;
    }
//
//    private PropertyMap<Track, TrackDto> trackPropertyMap = new PropertyMap<Track, TrackDto>() {
//        @Override
//        protected void configure() {
//            skip(destination.setId);
//        }
//    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
