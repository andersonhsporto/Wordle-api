package com.api.wordleapi.services;

import com.api.wordleapi.models.entities.WordleEntity;
import com.api.wordleapi.repositories.WordleRepository;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
public class CsvReader {

  private final WordleRepository wordleRepository;

  public CsvReader(WordleRepository wordleRepository) {
    this.wordleRepository = wordleRepository;
  }

  public void readCsv() throws IOException {
    var csvData = new ClassPathResource("words.csv").getFile();
    var parser = new CSVParser(new FileReader(csvData), CSVFormat.EXCEL);

    for (CSVRecord csvRecord : parser) {
      var word = csvRecord.get(0);
      var wordleEntity = new WordleEntity(word);

      wordleRepository.save(wordleEntity);
    }
  }

}
