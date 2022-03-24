package com.madthreed.questionspringboot.dto;

import com.madthreed.questionspringboot.entity.Answer;
import com.madthreed.questionspringboot.entity.Level;
import com.madthreed.questionspringboot.entity.Profile;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class QuestionDto {
    private Long id;
    private String name;
    private Long numOfCorr;
    @ToString.Exclude
    private List<AnswerDto> answers;
    private ProfileDto profile;
    private LevelDto level;
}
