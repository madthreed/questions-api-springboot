package com.madthreed.questionspringboot.services;

import com.madthreed.questionspringboot.dto.QuestionDto;

import java.util.List;

public interface QuestionService {
    List<QuestionDto> getAll();

    QuestionDto getById(Long id);

    QuestionDto create(QuestionDto questionDto);

    QuestionDto update(Long id, QuestionDto questionDto);

    void delete(Long id);
}
