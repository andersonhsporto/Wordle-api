package com.api.wordleapi.repositories;

import com.api.wordleapi.models.entities.WordleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordleRepository extends JpaRepository<WordleEntity, Long> {

}
