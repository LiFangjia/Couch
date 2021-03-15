package com.example.demo;

import static java.lang.String.format;

public class CouchDbUtil {

    public static void assertNotEmpty(Object object, String prefix) throws IllegalArgumentException {
        if(object == null) {
            throw new IllegalArgumentException(format("%s may not be null.", prefix));
        } else if(object instanceof String && ((String)object).length() == 0) {
            throw new IllegalArgumentException(format("%s may not be empty.", prefix));
        }
    }

    public static void assertNull(Object object, String prefix) throws IllegalArgumentException {
        if(object != null) {
            throw new IllegalArgumentException(format("%s should be null.", prefix));
        }
    }
}
