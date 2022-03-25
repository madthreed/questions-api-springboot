package com.madthreed.questionspringboot.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "answers")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ans_id")
    private Long id;

    @Column(name = "ans_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "que_id", updatable = false, insertable = false)
    @ToString.Exclude
    private Question question;
}
