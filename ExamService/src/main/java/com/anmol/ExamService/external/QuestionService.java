package com.anmol.ExamService.external;

import com.anmol.ExamService.model.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "QUESTION-SERVICE")
public interface QuestionService {

    @GetMapping("/question/{id}")
    ResponseEntity<Question> getQuestionById(@PathVariable("id") String id);

}
