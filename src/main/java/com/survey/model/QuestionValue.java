package com.survey.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class QuestionValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questionValue_id")
    private Long questionValueId;

    private int value;

    //관계 설정
//    @ManyToOne
//    @JoinColumn(name = "Question_Id")
//    private Question question;

    @JsonBackReference
    @ManyToOne(targetEntity = Question.class)
    @JoinColumn(name = "question_id")
    private Question question;
}
