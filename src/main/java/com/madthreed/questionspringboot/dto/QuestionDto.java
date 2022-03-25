package com.madthreed.questionspringboot.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class QuestionDto  extends RepresentationModel<QuestionDto> {
    private Long id;
    private String name;
    private Long numOfCorr;

//    @ToString.Exclude
    @JsonManagedReference
    private List<AnswerDto> answers;

    @JsonManagedReference
    private ProfileDto profile;

    @JsonManagedReference
    private LevelDto level;
}
