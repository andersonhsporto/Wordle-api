package com.api.wordleapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/wordle")
public class WordleController {

  @GetMapping
  public ResponseEntity<?> getWordle() {
    return ResponseEntity.ok("Hello World");
  }

}
