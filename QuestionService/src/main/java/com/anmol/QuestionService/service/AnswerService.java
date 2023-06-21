package com.anmol.QuestionService.service;

import com.anmol.QuestionService.model.Answer;
import com.anmol.QuestionService.model.Question;
import com.anmol.QuestionService.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    QuestionService questionService;

    public Answer save(Answer answer) {
        Question byId = questionService.findById(answer.getQuestionId());
        answer.setQuestion(byId);
        byId.addAnswer(answer);
        return answerRepository.save(answer);
    }

}
