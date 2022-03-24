package com.madthreed.questionspringboot.repository;

import com.madthreed.questionspringboot.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
