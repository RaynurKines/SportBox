package com.example.sportbox.model;

import com.example.sportbox.model.enums.CompetitionLevel;
import com.example.sportbox.model.enums.KindOfSport;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Event {

    private int eventId;
    @NonNull
    private String name;
    @NonNull
    private Date date;
    @NonNull
    private KindOfSport kindOfSport;
    @Singular
    private List<Competition> competitions;
    @NonNull
    private CompetitionLevel competitionLevel;


}
