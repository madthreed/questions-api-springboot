package com.madthreed.questionspringboot.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "questions")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "que_id")
    private Long id;

    @Column(name = "que_name")
    private String name;

    private Long numOfCorr;

    @OneToMany(mappedBy = "question")
    @ToString.Exclude
    private List<Answer> answers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prof_id")
    @ToString.Exclude
    private Profile profile;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lvl_id")
    @ToString.Exclude
    private Level level;


    void addAnswer(Answer answer) {
        if (answers == null) {
            answers = new ArrayList<>();
        }

        answers.add(answer);
        answer.setQuestion(this);
    }


    void removeAnswer(Answer answer) {

        answers.remove(answer);
        answer.setQuestion(null);
    }
}
