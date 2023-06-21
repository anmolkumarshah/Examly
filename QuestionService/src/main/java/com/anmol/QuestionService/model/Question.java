package com.anmol.QuestionService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

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
    List<Answer> answers;

//    String createdBy

    @CreationTimestamp
    Date createdOn;

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

}
