package com.anmol.ExamService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Question {

    @Id
    String id;

    String text;

    @OneToMany(mappedBy = "question")
    List<Answer> answers = List.of();

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "exam_question")
    List<Exam> exams = new ArrayList<>();

//    public void addExam(Exam exam) {
//        exams.add(exam);
//    }

//    String createdBy

//    @CreationTimestamp
//    Date createdOn;
//
//    public void addAnswer(Answer answer) {
//        answers.add(answer);
//    }

}
