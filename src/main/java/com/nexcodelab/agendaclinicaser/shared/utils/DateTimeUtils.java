package com.nexcodelab.agendaclinicaser.shared.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateTimeUtils {
    public static LocalDateTime toLocalDate(String data){
        Pattern pattern = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");
        Matcher matcher = pattern.matcher(data);
        if(!matcher.matches()){
            throw new IllegalArgumentException("Data não está no formato especificado.");
        }

        return LocalDateTime.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public static LocalDateTime toLocalDateTime(String data){
        Pattern pattern = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}");
        Matcher matcher = pattern.matcher(data);
        if(!matcher.matches()){
            throw new IllegalArgumentException("data e hora não estão no formato especificado.");
        }

        return LocalDateTime.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}
