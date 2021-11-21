package com.example.sportbox.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum Sex {
    male("Муж"),
    female("Жен");

    private final String label;

    public String getLabel() {
        return label;
    }

    Sex(String label){
        this.label = label;
    }

    private static Map<String, Sex> map = new HashMap<>();
    static {
        for (Sex sex : Sex.values()){
            map.put(sex.label, sex);
        }
    }

    // get по uid
    public static Sex getSexByLabel(String label) {
        return map.get(label);
    }

}
