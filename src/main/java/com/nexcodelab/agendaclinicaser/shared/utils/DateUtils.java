package com.nexcodelab.agendaclinicaser.shared.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtils {
    public static LocalDate toLocalDate(String data){
        Pattern pattern = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");
        Matcher matcher = pattern.matcher(data);
        if(!matcher.matches()){
            throw new IllegalArgumentException("Data não está no formato especificado.");
        }

        return LocalDate.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public static LocalDateTime toLocalDateTime(String data){
        Pattern pattern = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}");
        Matcher matcher = pattern.matcher(data);
        if(!matcher.matches()){
            throw new IllegalArgumentException("data e hora não estão no formato especificado.");
        }

        return LocalDateTime.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public static Boolean isLocalDateGreaterOrEqual(LocalDate start,  LocalDate end){
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
