package com.anmol.QuestionService.repository;

import com.anmol.QuestionService.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question,String> {
}
