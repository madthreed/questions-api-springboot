package com.madthreed.questionspringboot.repository;

import com.madthreed.questionspringboot.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
