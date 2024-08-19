package com.nexcodelab.uniforum.shared.utils;

import java.util.Collection;

public class Validations {
    public static boolean isEmpty (Collection<?> value) {
        return value == null || value.isEmpty();
    }

    public static boolean isEmpty(String value){
        return value == null || value.trim().isEmpty();
    }

}
