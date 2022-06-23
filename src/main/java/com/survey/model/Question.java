package com.survey.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long questionId;


    @Column(name = "question_content")
    private String questionContent;


    @JsonManagedReference
    @OneToMany(mappedBy = "question")
    private List<QuestionValue> questionValue = new ArrayList<>();


    @JsonBackReference
    @ManyToOne(targetEntity = Survey.class)
    @JoinColumn(name = "survey_id")
    private Survey survey;

}