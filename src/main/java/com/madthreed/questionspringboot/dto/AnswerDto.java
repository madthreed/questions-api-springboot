package com.madthreed.questionspringboot.dto;

import com.madthreed.questionspringboot.entity.Question;
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
    private QuestionDto question;
}
