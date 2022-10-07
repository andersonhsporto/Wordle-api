package com.api.wordleapi.models.dto;

import javax.persistence.criteria.CriteriaBuilder.In;

public class WordleDTO {

  private String word;

  private String response;

  private Integer attempts;

  public WordleDTO() {
  }

  public WordleDTO(String word, String response, Integer attempts) {
    this.word = word;
    this.response = response;
    this.attempts = attempts;
  }

  public static WordleDTO of(String word, String response, Integer attempts) {
    return new WordleDTO(word, response, attempts);
  }

  public String getWord() {
    return word;
  }

  public String getResponse() {
    return response;
  }

  public Integer getAttempts() {
    return attempts + 1;
  }
}
