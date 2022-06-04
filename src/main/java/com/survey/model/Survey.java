package com.survey.model;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Survey {


    private Long surveyId;
    private int userId;
    private String surveyName;
    private String publishState;
    private int required;
    private LocalDate publishStart;
    private LocalDate publishEnd;

}
