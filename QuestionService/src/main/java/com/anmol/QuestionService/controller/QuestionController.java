package com.anmol.QuestionService.controller;

import com.anmol.QuestionService.model.Question;
import com.anmol.QuestionService.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping
    public ResponseEntity<Question> save(@RequestBody Question question) {
        Question createdQuestion = questionService.save(question);
        return ResponseEntity.ok(createdQuestion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable("id") String id) {
        Question byId = questionService.findById(id);
        return ResponseEntity.ok(byId);
    }

}
