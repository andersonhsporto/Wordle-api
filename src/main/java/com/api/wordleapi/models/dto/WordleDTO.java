package com.api.wordleapi.models.dto;

public class WordleDTO {

  private String word;

  private String response;

  public WordleDTO() {
  }

  public WordleDTO(String word, String response) {
    this.word = word;
    this.response = response;
  }

  public static WordleDTO of(String word, String response) {
    return new WordleDTO(word, response);
  }

  public String getWord() {
    return word;
  }

  public String getResponse() {
    return response;
  }
}
