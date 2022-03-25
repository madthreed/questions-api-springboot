package com.madthreed.questionspringboot.services.impl;

import com.madthreed.questionspringboot.dto.LevelDto;
import com.madthreed.questionspringboot.entity.Level;
import com.madthreed.questionspringboot.exeption.NotFoundLevelException;
import com.madthreed.questionspringboot.repository.LevelRepository;
import com.madthreed.questionspringboot.services.LevelService;
import com.madthreed.questionspringboot.util.Mapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class LevelServiceImpl implements LevelService {
    private final LevelRepository levelRepository;
    private final Mapper mapper;


    @Override
    public List<LevelDto> getAll() {

        List<Level> levels = levelRepository.findAll();
        log.info("IN getAll - {} levels found", levels.size());

        return levels.stream()
                .map(level -> mapper.mapper(level, LevelDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public LevelDto getById(Long id) {

        Level level = levelRepository.findById(id).orElseThrow(() -> new NotFoundLevelException(id));
        log.info("IN getById - levels: {} found by id: {}", level, id);

        return mapper.mapper(level, LevelDto.class);
    }


    @Override
    public LevelDto create(LevelDto levelDto) {

        Level level = mapper.mapper(levelDto, Level.class);
        Level saved = levelRepository.save(level);
        log.info("IN create - {} level successfully created", saved);

        return mapper.mapper(saved, LevelDto.class);
    }


    @Override
    public LevelDto update(Long id, LevelDto levelDto) {

        Level level = levelRepository.findById(id).orElseThrow(() -> new NotFoundLevelException(id));
        level.setName(levelDto.getName());
        //todo
        Level saved = levelRepository.save(level);
        log.info("IN update - level: {} with id: {} successfully updated", saved, id);

        return mapper.mapper(saved, LevelDto.class);
    }


    @Override
    public void delete(Long id) {

        Level level = levelRepository.findById(id).orElseThrow(() -> new NotFoundLevelException(id));
        levelRepository.delete(level);
        log.info("IN delete - level with id: {} successfully deleted", id);
    }
}
