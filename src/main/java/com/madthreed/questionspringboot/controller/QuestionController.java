package com.madthreed.questionspringboot.controller;

import com.madthreed.questionspringboot.dto.QuestionDto;
import com.madthreed.questionspringboot.services.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
@AllArgsConstructor
public class QuestionController {
    private final QuestionService questionService;


    @GetMapping
    public List<QuestionDto> getAll() {

        return questionService.getAll();
    }


    @GetMapping("/{id}")
    public QuestionDto getById(@PathVariable Long id) {

        return questionService.getById(id);
    }


    @PostMapping
    public QuestionDto create(@RequestBody QuestionDto dto) {

        return questionService.create(dto);
    }


    @PutMapping("/{id}")
    public QuestionDto update(@PathVariable Long id, @RequestBody QuestionDto dto) {

        return questionService.update(id, dto);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        questionService.delete(id);

//        return ResponseEntity.ok("Question deleted successfully");
    }
}
