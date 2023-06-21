package com.anmol.ExamService.controller;

import com.anmol.ExamService.model.Exam;
import com.anmol.ExamService.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    ExamService examService;

    @PostMapping
    public ResponseEntity<Exam> createExam(@RequestBody Exam exam) {
        Exam savedExam = examService.save(exam);
        return ResponseEntity.ok(savedExam);
    }

    @PutMapping("/add-question/{examId}/{questionId}")
    public ResponseEntity<Exam> addQuestion(@PathVariable("examId") String examId, @PathVariable("questionId") String questionId) {
        Exam exam = examService.addQuestion(examId, questionId);
        return ResponseEntity.ok(exam);
    }

    @GetMapping("/{examId}")
    public ResponseEntity<Exam> getExamById(@PathVariable("examId") String id) {
        return ResponseEntity.ok(examService.findExamById(id));
    }

}
