package com.madthreed.questionspringboot.services.impl;

import com.madthreed.questionspringboot.dto.AnswerDto;
import com.madthreed.questionspringboot.entity.Answer;
import com.madthreed.questionspringboot.exeption.NotFoundAnswerException;
import com.madthreed.questionspringboot.repository.AnswerRepository;
import com.madthreed.questionspringboot.services.AnswerService;
import com.madthreed.questionspringboot.util.Mapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;
    private final Mapper mapper;


    @Override
    public List<AnswerDto> getAll() {

        List<Answer> answers = answerRepository.findAll();
        log.info("IN getAll - {} answers found", answers.size());

        return answers.stream()
                .map(answer -> mapper.mapper(answer, AnswerDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public AnswerDto getById(Long id) {

        Answer answer = answerRepository.findById(id).orElseThrow(()->new NotFoundAnswerException(id));
        log.info("IN getById - answer: {} found by id: {}", answer, id);

        return mapper.mapper(answer, AnswerDto.class);
    }


    @Override
    public AnswerDto create(AnswerDto answerDto) {

        Answer answer = mapper.mapper(answerDto, Answer.class);
        Answer saved = answerRepository.save(answer);
        log.info("IN create - {} answer successfully created", saved);

        return mapper.mapper(saved, AnswerDto.class);
    }


    @Override
    public AnswerDto update(Long id, AnswerDto answerDto) {

        Answer answer = answerRepository.findById(id).orElseThrow(()->new NotFoundAnswerException(id));
        answer.setName(answerDto.getName());
        //todo
        Answer saved = answerRepository.save(answer);
        log.info("IN update - answer: {} with id: {} successfully updated", saved, id);

        return mapper.mapper(saved, AnswerDto.class);
    }


    @Override
    public void delete(Long id) {

        Answer answer = answerRepository.findById(id).orElseThrow(()->new NotFoundAnswerException(id));
        answerRepository.delete(answer);
        log.info("IN delete - answer with id: {} successfully deleted", id);
    }
}
