package com.madthreed.questionspringboot.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "profiles")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prof_id;


    @Column(name = "prof_name")
    private String name;


    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Question> questions;
}
