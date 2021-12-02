package com.example.sportbox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Competition {

    private int competitionId;
    private String name;
    private Event event;
    private List<Result> results;
}
