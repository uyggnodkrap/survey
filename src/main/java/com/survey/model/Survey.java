package com.survey.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long surveyId;
    private String surveyName;
    private String publishState;
    private int required;
    private LocalDate publishStart;
    private LocalDate publishEnd;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class) // student와 major의 관계는 다대일 (N:1)
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return "Survey{" +
                "user=" + user +
                '}';
    }
}
