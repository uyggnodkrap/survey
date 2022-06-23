package com.survey.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class ResponseDTO<T> {
    private String error;
}