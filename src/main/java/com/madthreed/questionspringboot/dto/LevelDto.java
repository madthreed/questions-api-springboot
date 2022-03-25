package com.madthreed.questionspringboot.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class LevelDto {
    private Long lvl_id;
    private String name;

    @JsonBackReference
    private List<QuestionDto> questions;
}
