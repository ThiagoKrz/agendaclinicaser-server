package com.nexcodelab.agendaclinicaser.shared.utils;

import java.time.LocalDate;
import java.util.Collection;

public class Validations {
    public static boolean isEmpty (Collection<?> value) {
        return value == null || value.isEmpty();
    }

    public static boolean isEmpty(String value){
        return value == null || value.trim().isEmpty();
    }
    public static Boolean isLocalDateGreaterOrEqual(LocalDate start, LocalDate end){
        return start.isEqual(end) || start.isAfter(end);
    }

    public static Boolean isLocalDateLessOrEqual(LocalDate start,  LocalDate end){
        return start.isEqual(end) || start.isBefore(end);
    }

    public static Boolean isLocalDateWithinRange(LocalDate value, LocalDate start,  LocalDate end){
        return (value.isEqual(start) || value.isAfter(start)) && (value.isEqual(end) || value.isBefore(end));
    }
    public static Boolean isLocalDateWithinRangeOrOpenEnd(LocalDate value, LocalDate start,  LocalDate end){
        return (value.isEqual(start) || value.isAfter(start)) && (end == null || value.isEqual(end) || value.isBefore(end));
    }

}
