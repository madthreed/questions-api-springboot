package com.madthreed.questionspringboot.controller;

import com.madthreed.questionspringboot.dto.ProfileDto;
import com.madthreed.questionspringboot.services.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/profile")
@AllArgsConstructor
public class ProfileController {
    private final ProfileService profileService;


    @GetMapping
    public List<ProfileDto> getAll() {

        return profileService.getAll();
    }


    @GetMapping("/get/{id}")
    public ProfileDto getById(@PathVariable Long id) {
        return profileService.getById(id);
    }


    @PostMapping
    public ResponseEntity<ProfileDto> create(@Valid @RequestBody ProfileDto profile) {

        ProfileDto result= profileService.create(profile);
        return ResponseEntity.ok(result);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProfileDto> update(@PathVariable Long id, @Valid @RequestBody ProfileDto profile) {

        ProfileDto result = profileService.update(id, profile);
        return ResponseEntity.ok(result);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        profileService.delete(id);

        return ResponseEntity.ok("Profile deleted successfully");
    }
}
