package com.pp.java.features.sealed;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SealedTest {

    @Test
    public void sealedSwitchTest() {
        assertEquals("1", resolve(new Red()));
        assertEquals("2", resolve(new Green()));
        assertEquals("3", resolve(new Blue()));
    }

    //replace using switch
    private String resolve(RGBColor color) {
        if (color instanceof Red) {
            return "1";
        } else if (color instanceof Green) {
            return "2";
        } else {
            return "3";
        }
    }
}

sealed abstract class RGBColor permits Red, Green, Blue {
}

final class Red extends RGBColor {
}

final class Green extends RGBColor {
}

final class Blue extends RGBColor {
}


