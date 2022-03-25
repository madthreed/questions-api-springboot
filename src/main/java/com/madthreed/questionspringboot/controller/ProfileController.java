package com.madthreed.questionspringboot.controller;

import com.madthreed.questionspringboot.dto.ProfileDto;
import com.madthreed.questionspringboot.services.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
@AllArgsConstructor
public class ProfileController {
    private final ProfileService profileService;


    @GetMapping
    public List<ProfileDto> getAll() {

        return profileService.getAll();
    }


    @GetMapping("/{id}")
    public ProfileDto getById(@PathVariable Long id) {

        return profileService.getById(id);
    }


    @PostMapping
    public ProfileDto create(@RequestBody ProfileDto dto) {

        return profileService.create(dto);
    }


    @PutMapping("/{id}")
    public ProfileDto update(@PathVariable Long id, @RequestBody ProfileDto dto) {

        return profileService.update(id, dto);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        profileService.delete(id);

//        return ResponseEntity.ok("Profile deleted successfully");
    }
}
