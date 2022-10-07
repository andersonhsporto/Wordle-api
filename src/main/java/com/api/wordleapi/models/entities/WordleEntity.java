package com.api.wordleapi.models.entities;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.apache.commons.csv.CSVRecord;

@Entity
public class WordleEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String word;

  private Integer count;

  public WordleEntity(String word) {
    this.word = word;
    this.count = 1;
  }

  public WordleEntity() {
  }

  public static WordleEntity fromCsv(CSVRecord csvRecord) {
    return new WordleEntity(csvRecord.get(0));
  }

  public String getWord() {
    return word;
  }

  public void incrementCount() {
    this.count++;
  }

  public void resetCount() {
    this.count = 1;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WordleEntity that = (WordleEntity) o;
    return Objects.equals(id, that.id) && Objects.equals(word, that.word);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, word);
  }

  @Override
  public String toString() {
    return "WordleEntity{" +
        "id=" + id +
        ", word='" + word + '\'' +
        '}';
  }
}
