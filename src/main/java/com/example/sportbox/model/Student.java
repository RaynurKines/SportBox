package com.example.sportbox.model;

import com.example.sportbox.model.enums.Sex;
import lombok.*;
import javax.persistence.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;
    private String name;
    private String lastname;
    private String patronymic;

    @Enumerated
    private Sex sex;

    @ManyToOne(/*fetch = FetchType.LAZY*/)
    private Group group;

    @Singular
    @OneToMany
    private List<Result> results;

    @NonNull
    private long phone;
}
