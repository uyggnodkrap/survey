package com.survey.dto.survey;

import lombok.*;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SurveyCreateByUserRequestDto {

    private String surveyName;
    private int required;

}
