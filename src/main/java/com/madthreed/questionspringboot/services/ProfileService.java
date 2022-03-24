package com.madthreed.questionspringboot.services;

import com.madthreed.questionspringboot.dto.ProfileDto;

import java.util.List;

public interface ProfileService {
    List<ProfileDto> getAll();

    ProfileDto getById(Long id);

    ProfileDto create(ProfileDto profile);

    ProfileDto update(Long id, ProfileDto profile);

    void delete(Long id);
}
