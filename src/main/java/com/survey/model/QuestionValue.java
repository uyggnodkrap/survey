package com.survey.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "question_value")
public class QuestionValue implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questionValue_id")
    private Long questionValueId;

    private int value;

    @JsonBackReference
    @ManyToOne(targetEntity = Question.class)
    @JoinColumn(name = "question_id")
    private Question question;

}
