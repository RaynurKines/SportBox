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

    public static Sex getSexByLabel(String label){
        for(Sex s : Sex.values()){
            if(label == s.getLabel())
                return s;
        }
        return null;
    }

}
