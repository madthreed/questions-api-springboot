package com.madthreed.questionspringboot.controller;

import com.madthreed.questionspringboot.dto.AnswerDto;
import com.madthreed.questionspringboot.services.AnswerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
@AllArgsConstructor
public class AnswerController {
    private final AnswerService answerService;


    @GetMapping
    public List<AnswerDto> getAll() {

        return answerService.getAll();
    }


    @GetMapping("/{id}")
    public AnswerDto getById(@PathVariable Long id) {

        return answerService.getById(id);
    }


    @PostMapping
    public AnswerDto create(@RequestBody AnswerDto dto) {

        return answerService.create(dto);
    }


    @PutMapping("/{id}")
    public AnswerDto update(@PathVariable Long id, @RequestBody AnswerDto dto) {

        return answerService.update(id, dto);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        answerService.delete(id);

//        return ResponseEntity.ok("Profile deleted successfully");
    }
}
