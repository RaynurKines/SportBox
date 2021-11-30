package com.example.sportbox.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum KindOfSport {
    BASKETBALL("баскетбол"),
    FIGHT_SAMBO("самбо"),
    VOLLEYBALL("волейбол"),
    WEIGHT_SPORT("тяжелая атлетика"),
    ATHLETICS("легкая атлетика"),
    TABLE_TENNIS("настольный тенис"),
    OLIPIAD(" "),
    PHYSICAL_TRAINING(" "),
    CHESS("шахматы");


    private final String label;

    public String getLabel() {
        return label;
    }

    KindOfSport(String label){
        this.label = label;
    }

    private static Map<String, KindOfSport> map = new HashMap<>();
    static {
        for (KindOfSport sport : KindOfSport.values()){
            map.put(sport.label, sport);
        }
    }

    public static KindOfSport getKindOfSportByLabel(String label) {return map.get(label);}
}
