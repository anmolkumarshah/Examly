package com.anmol.QuestionService.service;

import com.anmol.QuestionService.model.Question;
import com.anmol.QuestionService.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public Question save(Question question) {
        question.setId(UUID.randomUUID().toString());
        question.setAnswers(List.of());
        Question save = questionRepository.save(question);
        return save;
    }

    public Question findById(String id) {
        Optional<Question> byId = questionRepository.findById(id);
        if (byId.isPresent())
            return byId.get();
        return null;
    }

}
