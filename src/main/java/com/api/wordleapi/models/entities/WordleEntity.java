package com.api.wordleapi.models.entities;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WordleEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String word;

  public WordleEntity(String word) {
    this.word = word;
  }

  public WordleEntity() {
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
