package com.survey.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long surveyId;
    private int userId;
    private String surveyName;
    private String publishState;
    private int required;
    private LocalDate publishStart;
    private LocalDate publishEnd;

}
