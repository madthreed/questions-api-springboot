package com.madthreed.questionspringboot.services;

import com.madthreed.questionspringboot.dto.AnswerDto;
import com.madthreed.questionspringboot.dto.LevelDto;

import java.util.List;

public interface AnswerService {
    List<AnswerDto> getAll();

    AnswerDto getById(Long id);

    AnswerDto create(AnswerDto levelDto);

    AnswerDto update(Long id, AnswerDto levelDto);

    void delete(Long id);
}
