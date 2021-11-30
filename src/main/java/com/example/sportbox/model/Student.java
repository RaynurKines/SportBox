package com.example.sportbox.model;

import com.example.sportbox.model.enums.Sex;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Student {


    private int studentId;
    @NonNull
    private String name;
    @NonNull
    private String lastname;
    @NonNull
    private String patronymic;
    @NonNull
    private Sex sex;
    @NonNull
    private Group group;
    @Singular
    private List<Result> results;
    @NonNull
    private long phone;
}
