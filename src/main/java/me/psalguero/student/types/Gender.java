package me.psalguero.student.types;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Gender {

    MASCULINE("M", "Masculino"),
    FEMININE("F", "Femenino");

    private final String code;
    private final String value;

    Gender(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public static Gender findByCode(String code) {
        return Arrays.stream(Gender.values())
                .filter(g -> g.code.equals(code))
                .findFirst()
                .orElse(null);
    }


}
