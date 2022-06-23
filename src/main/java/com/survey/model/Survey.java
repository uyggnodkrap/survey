package com.survey.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_id")
    private Long surveyId;

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


    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonManagedReference
    @OneToMany(mappedBy = "survey")
    private List<Question> question = new ArrayList<>();


    @Override
    public String toString() {
        return "Survey{" +
                "user=" + user +
                '}';
    }

}
