package com.madthreed.questionspringboot.services.impl;

import com.madthreed.questionspringboot.dto.ProfileDto;
import com.madthreed.questionspringboot.entity.Profile;
import com.madthreed.questionspringboot.exeption.NotFoundProfileException;
import com.madthreed.questionspringboot.repository.ProfileRepository;
import com.madthreed.questionspringboot.services.ProfileService;
import com.madthreed.questionspringboot.util.Mapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;
    private final Mapper mapper;


    @Override
    public List<ProfileDto> getAll() {

        List<Profile> profiles = profileRepository.findAll();
        log.info("IN getAll - {} profiles found", profiles.size());

        return profiles.stream()
                .map(profile -> mapper.mapper(profile, ProfileDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public ProfileDto getById(Long id) {

        Profile profile = profileRepository.findById(id).orElseThrow(()->new NotFoundProfileException(id));
        log.info("IN getById - profile: {} found by id: {}", profile, id);

        return mapper.mapper(profile, ProfileDto.class);
    }


    @Override
    public ProfileDto create(ProfileDto profileDto) {

        Profile profile = mapper.mapper(profileDto, Profile.class);
        Profile saved = profileRepository.save(profile);
        log.info("IN create - {} profile successfully created", saved);

        return mapper.mapper(saved, ProfileDto.class);
    }


    @Override
    public ProfileDto update(Long id, ProfileDto profileDto) {

        Profile profile = profileRepository.findById(id).orElseThrow(()->new NotFoundProfileException(id));
        profile.setName(profileDto.getName());
        //todo
        Profile saved = profileRepository.save(profile);
        log.info("IN update - profile: {} with id: {} successfully updated", saved, id);

        return mapper.mapper(saved, ProfileDto.class);
    }


    @Override
    public void delete(Long id) {

        Profile profile = profileRepository.findById(id).orElseThrow(()->new NotFoundProfileException(id));
        profileRepository.delete(profile);
        log.info("IN delete - profile with id: {} successfully deleted", id);
    }
}
