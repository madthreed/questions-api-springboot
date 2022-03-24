package com.madthreed.questionspringboot.repository;

import com.madthreed.questionspringboot.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
