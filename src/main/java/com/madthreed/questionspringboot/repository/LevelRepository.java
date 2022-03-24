package com.madthreed.questionspringboot.repository;

import com.madthreed.questionspringboot.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepository extends JpaRepository<Level, Long> {
}
