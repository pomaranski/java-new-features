package com.pp.java.features.collections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ImmutableCollectionsTest {

    @Test
    public void shouldInitializeListUsingListApi() {
        // TODO create immutable list with elements 1, 2, 3 using list api https://docs.oracle.com/javase/9/docs/api/java/util/List.html
        var list = new ArrayList<>();

        assertEquals(Arrays.asList(1, 2, 3), list);
    }

    // TODO HOMEWORK
    @Test
    public void shouldThrowExceptionWhenModifyImmutableList() {
        // TODO create immutable list with elements 1, 2 using stream api https://docs.oracle.com/javase/9/docs/api/java/util/stream/Collectors.html
        var list = new ArrayList<Integer>();

        assertEquals(Arrays.asList(1, 2), list);
        assertThrows(UnsupportedOperationException.class, () -> list.add(0));
        assertThrows(UnsupportedOperationException.class, () -> list.remove(0));
        assertThrows(UnsupportedOperationException.class, () -> list.set(0, 0));
        assertThrows(UnsupportedOperationException.class, () -> Collections.sort(list));
    }

    @Test
    public void shouldInitializeImmutableMapUsingMapApi() {
        // TODO create immutable list with elements 1 -> "a", 2 -> "b" using map api https://docs.oracle.com/javase/9/docs/api/java/util/Map.html
        var map = new HashMap<Integer, String>();

        assertEquals(new HashMap<Integer, String>() {{
            put(1, "a");
            put(2, "b");
        }}, map);
    }

    // TODO HOMEWORK
    @Test
    public void shouldInitializeImmutableMapUsingStreamApi() {
        // TODO create immutable map with elements 1 -> "1", 2 -> "2" using map api
        var map = new HashMap<Integer, String>();

        assertEquals(new HashMap<Integer, String>() {{
            put(1, "1");
            put(2, "2");
        }}, map);
    }

    @Test
    public void shouldCopyCollections() {
        var list = Collections.singletonList("1");
        var set = Collections.singleton("1");
        var map = new HashMap<Integer, String>() {{
            put(1, "1");
        }};

        // TODO copy collections creating immutable versions of them
        var copyList = new ArrayList<>(list);
        var copySet = new HashSet<>(set);
        var copyMap = new HashMap<>(map);

        assertEquals(list, copyList);
        assertEquals(set, copySet);
        assertEquals(map, copyMap);

        assertThrows(UnsupportedOperationException.class, () -> copyList.add("0"));
        assertThrows(UnsupportedOperationException.class, () -> copySet.add("0"));
        assertThrows(UnsupportedOperationException.class, () -> copyMap.put(0, "0"));
    }

}

