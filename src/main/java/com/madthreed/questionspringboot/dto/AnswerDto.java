package com.madthreed.questionspringboot.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class AnswerDto {
    private Long id;
    private String name;

    @JsonBackReference
    private QuestionDto question;
}
