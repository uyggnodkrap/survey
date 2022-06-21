package com.survey.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long surveyId;
    private int userId;
    private String surveyName;
    private String publishState;
    private int required;
    private LocalDate publishStart;
    private LocalDate publishEnd;

}
