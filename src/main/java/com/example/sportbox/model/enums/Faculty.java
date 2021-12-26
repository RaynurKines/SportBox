package com.example.sportbox.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum Faculty {
    ADM("АДМ"),
    AT("АТ"),
    IMA("ИМА"),
    ISU("ИСУ"),
    NST("НСТ"),
    PGS("ПГС"),
    EIU("ЭиУ");

    private final String label;

    public String getLabel() {
        return label;
    }

    Faculty(String label){
        this.label = label;
    }

    public static Faculty getFacultyByLabel(String label){
        return map.get(label);
    }
    private static Map<String, Faculty> map = new HashMap<>();
    static {
        for (Faculty faculty : Faculty.values()){
            map.put(faculty.label, faculty);
        }
    }
}
