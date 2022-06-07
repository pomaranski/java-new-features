package com.pp.java.features.pattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatternTest {

    @Test
    public void patternMatching() {
        assertEquals("25", manipulate(5));
        assertEquals("", manipulate(new Object()));
        assertEquals("ab1", manipulate("ab"));
        assertEquals("abcd2", manipulate("abcd"));
        assertEquals("abcdef", manipulate("abcdef"));

    }

    // TODO refactor using pattern matching
    private String manipulate(Object obj) {
        if (obj instanceof Integer) {
            return String.valueOf((Integer) obj * 5);
        } else if (obj instanceof String) {
            var str = ((String) obj);
            if (str.length() < 3) {
                return str + "1";
            } else if (str.length() < 5) {
                return str + "2";
            } else {
                return str;
            }
        } else {
            return "";
        }
    }
}
