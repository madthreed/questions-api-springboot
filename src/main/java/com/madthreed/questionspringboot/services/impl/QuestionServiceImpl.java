package com.madthreed.questionspringboot.services.impl;

import com.madthreed.questionspringboot.dto.QuestionDto;
import com.madthreed.questionspringboot.entity.Question;
import com.madthreed.questionspringboot.exeption.NotFoundQuestionException;
import com.madthreed.questionspringboot.repository.QuestionRepository;
import com.madthreed.questionspringboot.services.QuestionService;
import com.madthreed.questionspringboot.util.Mapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final Mapper mapper;


    @Override
    public List<QuestionDto> getAll() {

        List<Question> questions = questionRepository.findAll();
        log.info("IN getAll - {} questions found", questions.size());

        return questions.stream()
                .map(question -> mapper.mapper(question, QuestionDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public QuestionDto getById(Long id) {

        Question question = questionRepository.findById(id).orElseThrow(()->new NotFoundQuestionException(id));
        log.info("IN getById - question: {} found by id: {}", question, id);

        return mapper.mapper(question, QuestionDto.class);
    }


    @Override
    public QuestionDto create(QuestionDto questionDto) {

        Question question = mapper.mapper(questionDto, Question.class);
        Question saved = questionRepository.save(question);
        log.info("IN create - {} question successfully created", saved);

        return mapper.mapper(saved, QuestionDto.class);
    }


    @Override
    public QuestionDto update(Long id, QuestionDto questionDto) {

        Question question = questionRepository.findById(id).orElseThrow(()->new NotFoundQuestionException(id));
        question.setName(questionDto.getName());
        question.setNumOfCorr(questionDto.getNumOfCorr());
//todo
        Question saved = questionRepository.save(question);
        log.info("IN update - question: {} with id: {} successfully updated", saved, id);

        return mapper.mapper(saved, QuestionDto.class);
    }


    @Override
    public void delete(Long id) {

        Question question = questionRepository.findById(id).orElseThrow(()->new NotFoundQuestionException(id));
        questionRepository.delete(question);
        log.info("IN delete - question with id: {} successfully deleted", id);
    }
}
