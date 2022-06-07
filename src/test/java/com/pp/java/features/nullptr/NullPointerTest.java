package com.pp.java.features.nullptr;

import org.junit.jupiter.api.Test;

import java.util.Map;

public class NullPointerTest {

    // Since Java 14
    @Test
    public void helpfulException() {
        Map<Integer, String> nulMap = null;
        Map<Integer, String> map = Map.of();

        try {
            nulMap.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            map.get(0).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
