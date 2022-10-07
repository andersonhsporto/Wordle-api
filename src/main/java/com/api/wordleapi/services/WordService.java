package com.api.wordleapi.services;

import com.api.wordleapi.models.dto.WordleDTO;
import com.api.wordleapi.repositories.WordleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WordService {

  private final WordleRepository wordleRepository;
  private String currentWord;
  private Integer currentWordCount;
  private Integer attemptCount;

  public WordService(WordleRepository wordleRepository) {
    this.wordleRepository = wordleRepository;
    this.currentWord = "";
    this.currentWordCount = 0;
    this.attemptCount = 0;
  }

  public ResponseEntity<?> getWordle(WordleDTO wordleDTO) {
    var word = wordleDTO.getWord();
    var stringResponse = responseWordle(wordleDTO.getWord());

    if (currentWordCount == 0 || attemptCount == 4) {
      currentWord = randomWord();
      currentWordCount = 1;
      attemptCount = 0;
    } else if (currentWord.equals(word)) {
      currentWord = randomWord();
      currentWordCount++;
      attemptCount = 0;
    } else {
      attemptCount++;
    }
    return new ResponseEntity<>(
        WordleDTO.of(word, stringResponse, attemptCount), null, 200);
  }


  //C if the character is same as the current word
  //T if the character exists in the current word but in different position
  //F if the character does not exist in the current word
  private String responseWordle(String word) {
    StringBuilder response = new StringBuilder();

    for (int i = 0; i < word.length(); i++) {
      if (i < currentWord.length() && word.charAt(i) == currentWord.charAt(i)) {
        response.append("C");
      } else if (currentWord.contains(String.valueOf(word.charAt(i)))) {
        response.append("T");
      } else {
        response.append("F");
      }
    }
    return response.toString();
  }

  private String randomWord() {
    var count = wordleRepository.count();
    var randomId = (long) (Math.random() * (count + 1) + 1);
    var randomWord = wordleRepository.findById(randomId);

    if (randomWord.isPresent()) {
      return randomWord.get().getWord();
    }
    return randomWord();
  }

}
