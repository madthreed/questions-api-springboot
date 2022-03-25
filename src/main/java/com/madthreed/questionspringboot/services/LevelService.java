package com.madthreed.questionspringboot.services;

import com.madthreed.questionspringboot.dto.LevelDto;

import java.util.List;

public interface LevelService {
    List<LevelDto> getAll();

    LevelDto getById(Long id);

    LevelDto create(LevelDto levelDto);

    LevelDto update(Long id, LevelDto levelDto);

    void delete(Long id);
}
