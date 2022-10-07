package com.api.wordleapi;

import com.api.wordleapi.services.CsvReader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WordleApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(WordleApiApplication.class, args);
  }

  @Bean
  CommandLineRunner updateDatabase(CsvReader csvReader) {
    return args -> csvReader.readCsv();
  }

}
