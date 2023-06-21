package com.anmol.ExamService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = "question")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

//    @Transient
//    @JsonIgnore
//    String questionId;

    String text;

//    @CreationTimestamp
//    Date createdOn;

    boolean correct;

    @ManyToOne
    @JsonIgnore
    Question question;

}
