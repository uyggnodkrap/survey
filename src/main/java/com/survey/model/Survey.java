package com.survey.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_id")
    private Long surveyId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "survey_name", nullable = false)
    private String surveyName;

    @Column(name = "publish_state", nullable = false)
    private String publishState;

    @Column(nullable = false)
    private int required;

    @Column(name = "publish_start")
    private LocalDate publishStart;

    @Column(name = "publish_end")
    private LocalDate publishEnd;


    @JsonManagedReference
    @OneToMany(mappedBy = "survey")
    private List<Question> question = new ArrayList<>();

}
