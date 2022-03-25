package com.madthreed.questionspringboot.controller;

import com.madthreed.questionspringboot.dto.LevelDto;
import com.madthreed.questionspringboot.services.LevelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/levels")
@AllArgsConstructor
public class LevelController {
    private final LevelService levelService;


    @GetMapping
    public List<LevelDto> getAll() {

        return levelService.getAll();
    }


    @GetMapping("/{id}")
    public LevelDto getById(@PathVariable Long id) {

        return levelService.getById(id);
    }


    @PostMapping
    public LevelDto create(@RequestBody LevelDto dto) {

        return levelService.create(dto);
    }


    @PutMapping("/{id}")
    public LevelDto update(@PathVariable Long id, @RequestBody LevelDto dto) {

        return levelService.update(id, dto);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        levelService.delete(id);

//        return ResponseEntity.ok("Profile deleted successfully");
    }
}
