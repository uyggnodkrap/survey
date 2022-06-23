package com.survey.dto.survey;

import lombok.*;

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
