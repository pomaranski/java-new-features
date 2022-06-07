package com.pp.java.features.files;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilesTest {

    @Test
    public void writeAndRead() {
        var message = "File content";

        //TODO write to file https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/file/Files.html

        //TODO read from file https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/file/Files.html
        String readValue = null;

        assertEquals(message, readValue);
    }

    @Test
    public void mismatch() {
        // TODO use https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/nio/file/Files.html#mismatch(java.nio.file.Path,java.nio.file.Path) api to compare files content
        assertEquals(-1, 0); // 1.txt and 1.txt
        assertEquals(0, 0); // 1.txt and 2.txt
        assertEquals(1, 0); // 1.txt and 11.txt
    }
}
