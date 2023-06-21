package com.anmol.ExamService.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Exam {

    @Id
    String id;

    String title;

    @ManyToMany(mappedBy = "exams", cascade = CascadeType.ALL)
    List<Question> questions = new ArrayList<>();

//    public void addQuestion(Question question) {
//        questions.add(question);
//    }


}
