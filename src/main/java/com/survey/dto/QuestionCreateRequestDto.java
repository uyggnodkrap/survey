package com.survey.dto;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionCreateRequestDto {

    private String questionContent;

}
