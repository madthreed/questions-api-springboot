package com.madthreed.questionspringboot.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Answer> answers;

    @ManyToOne
    @JoinColumn(name = "prof_id")
    private Profile profile;


    @ManyToOne
    @JoinColumn(name = "lvl_id")
    private Level level;
}
