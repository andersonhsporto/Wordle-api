package com.api.wordleapi.controller;

import com.api.wordleapi.models.dto.WordleDTO;
import com.api.wordleapi.services.WordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/v1/wordle")
public class WordleController {

  private final WordService wordService;

  public WordleController(WordService wordService) {
    this.wordService = wordService;
  }

  @GetMapping
  public ResponseEntity<?> getWordle(@RequestBody WordleDTO wordleDTO) {
    return wordService.getWordle(wordleDTO);
  }

}
