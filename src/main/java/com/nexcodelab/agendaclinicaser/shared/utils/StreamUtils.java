package com.nexcodelab.agendaclinicaser.shared.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.function.Function;
import java.util.function.Predicate;

public class StreamUtils {

    public static <T> Predicate<T> isLocalTimeGreaterOrEqual(Function<? super T, LocalTime> getStart, Function<? super T, LocalTime> getEnd) {
        return t -> getStart.apply(t).compareTo(getEnd.apply(t)) >= 0;
    }

    public static <T> Predicate<T> isLocalTimeLessOrEqual(Function<? super T, LocalTime> getStart, Function<? super T, LocalTime> getEnd) {
        return t -> getStart.apply(t).compareTo(getEnd.apply(t)) <= 0;
    }

//    public static <T> Predicate<T> isLocalTimeWithinRange(Function<? super T, LocalTime> getValue, Function<? super T, LocalTime> getStart, Function<? super T, LocalTime> getEnd) {
//        return t -> getValue.apply(t).compareTo(getStart.apply(t)) >= 0
//                && getValue.apply(t).compareTo(getEnd.apply(t)) <= 0;
//    }

    public static <T> Predicate<T> isDateGreaterOrEqual(Function<? super T, LocalDate> getStart, Function<? super T, LocalDate> getEnd) {
        return t -> Validations.isLocalDateGreaterOrEqual(getStart.apply(t), getEnd.apply(t));
    }

    public static <T> Predicate<T> isDateLessOrEqual(Function<? super T, LocalDate> getStart, Function<? super T, LocalDate> getEnd) {
        return t -> Validations.isLocalDateLessOrEqual(getStart.apply(t), getEnd.apply(t));
    }

//    public static <T> Predicate<T> isDateWithinRange(Function<? super T, LocalDate> getValue, Function<? super T, LocalDate> getStart, Function<? super T, LocalDate> getEnd) {
//        return t -> getValue.apply(t).compareTo(getStart.apply(t)) >= 0 && getValue.apply(t).compareTo(getEnd.apply(t)) <= 0;
//    }

//    public static <T> Predicate<T> isDateWithinRangeOrOpenEnd(Function<? super T, LocalDate> getValue, Function<? super T, LocalDate> getStart, Function<? super T, LocalDate> getEnd) {
//        return t -> getValue.apply(t).compareTo(getStart.apply(t)) >= 0 && (getEnd.apply(t) == null || getValue.apply(t).compareTo(getEnd.apply(t)) <= 0);
//    }
}
