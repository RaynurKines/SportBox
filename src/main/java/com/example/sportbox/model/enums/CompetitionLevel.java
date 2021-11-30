package com.example.sportbox.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum CompetitionLevel {
    INTERCOLLEGIATE("межвузовое"),
    INTRA_UNIVERSITY("внутривузовое");

    private final String label;

    public String getLabel() {
        return label;
    }

    CompetitionLevel(String label){
        this.label = label;
    }

    private static Map<String, CompetitionLevel> map = new HashMap<>();
    static {
        for (CompetitionLevel level : CompetitionLevel.values()){
            map.put(level.label, level);
        }
    }

    public static CompetitionLevel getCompetitionLevelByLabel(String label) {return map.get(label);}
}
