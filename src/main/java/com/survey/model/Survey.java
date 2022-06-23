package com.survey.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "survey")
public class Survey extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_id")
    private int surveyId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
//    private int userId;

    @Column(name = "survey_name")
    private String surveyName;

    @Column(name = "publish_state")
    private int publishState;

    private int required;


//    @Column(name = "publish_start")
//    private LocalDate publishStart;
//
//    @Column(name = "publish_end")
//    private LocalDate publishEnd;

}
