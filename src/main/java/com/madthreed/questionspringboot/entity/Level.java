package com.madthreed.questionspringboot.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "levels")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lvl_id;

    @Column(name = "lvl_name")
    private String name;

    @OneToMany(mappedBy = "level", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Question> questions;
}
