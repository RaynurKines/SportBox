package com.example.sportbox.model;

import com.example.sportbox.model.enums.Sex;
import lombok.*;
import javax.persistence.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String lastname;
    private String patronymic;

    @Enumerated
    private Sex sex;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @Singular
    @OneToMany(mappedBy = "student")
    private List<Result> results;

    @NonNull
    private long phone;
}
