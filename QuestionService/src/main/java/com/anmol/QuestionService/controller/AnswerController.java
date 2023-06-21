package com.anmol.QuestionService.controller;

import com.anmol.QuestionService.model.Answer;
import com.anmol.QuestionService.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @PostMapping
    public ResponseEntity<Answer> save(@RequestBody Answer answer) {
        Answer createdAnswer = answerService.save(answer);
        return ResponseEntity.ok(createdAnswer);
    }

}
