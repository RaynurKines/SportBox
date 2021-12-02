package com.example.sportbox.model;

import com.example.sportbox.model.enums.CompetitionLevel;
import com.example.sportbox.model.enums.KindOfSport;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long eventId;

    private String name;
    private Date date;
    @Enumerated
    private KindOfSport kindOfSport;

    @Singular
    @OneToMany
    private List<Competition> competitions;

    @Enumerated
    private CompetitionLevel competitionLevel;


}
