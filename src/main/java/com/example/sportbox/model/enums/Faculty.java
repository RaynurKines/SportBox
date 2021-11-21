package com.example.sportbox.model.enums;

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
        for(Faculty f : Faculty.values()){
            if(label == f.getLabel())
                return f;
        }
        return null;
    }
}
