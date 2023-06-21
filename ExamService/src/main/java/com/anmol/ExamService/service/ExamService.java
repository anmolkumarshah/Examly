package com.anmol.ExamService.service;

import com.anmol.ExamService.model.Exam;
import com.anmol.ExamService.model.Question;
import com.anmol.ExamService.repository.ExamRepository;
import com.anmol.ExamService.external.QuestionService;
import com.anmol.ExamService.repository.QuestionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ExamService {

    @Autowired
    ExamRepository examRepository;

    @Autowired
    QuestionService questionService;

    @Autowired
    QuestionRepository questionRepository;

    public Exam save(Exam exam) {
        exam.setId(UUID.randomUUID().toString());
        return examRepository.save(exam);
    }

    public Exam update(Exam exam) {
        return examRepository.save(exam);
    }

    public Exam findExamById(String id) {
        Optional<Exam> byId = examRepository.findById(id);
        if (byId.isPresent()) return byId.get();
        return null;
    }

    @Transactional
    public Exam addQuestion(String examId, String questionId) {
        ResponseEntity<Question> questionById = questionService.getQuestionById(questionId);
        Question question = questionById.getBody();

        Exam examById = findExamById(examId);
        examById.getQuestions().add(question);

        question.getExams().add(examById);

        questionRepository.save(question);

        return update(examById);
    }

}
