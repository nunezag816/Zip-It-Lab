package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ZipUtilsTest {

    @Test
    void testZipEqualLengthLists() {
        List<Integer> list1 = List.of(1, 3, 5);
        List<Integer> list2 = List.of(2, 4, 6);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        assertEquals(expected, ZipUtils.zip(list1, list2));
    }

    @Test
    void testZipFirstListLonger() {
        List<String> list1 = List.of("A", "B", "C", "D");
        List<String> list2 = List.of("1", "2");
        List<String> expected = List.of("A", "1", "B", "2", "C", "D");
        assertEquals(expected, ZipUtils.zip(list1, list2));
    }

    @Test
    void testZipSecondListLonger() {
        List<String> list1 = List.of("X", "Y");
        List<String> list2 = List.of("1", "2", "3");
        List<String> expected = List.of("X", "1", "Y", "2", "3");
        assertEquals(expected, ZipUtils.zip(list1, list2));
    }

    @Test
    void testZipEmptyLists() {
        List<Object> list1 = List.of();
        List<Object> list2 = List.of();
        List<Object> expected = List.of();
        assertEquals(expected, ZipUtils.zip(list1, list2));
    }

    @Test
    void testZipOneEmptyOneFilled() {
        List<String> list1 = List.of("A", "B");
        List<String> list2 = List.of();
        List<String> expected = List.of("A", "B");
        assertEquals(expected, ZipUtils.zip(list1, list2));
    }


    @Test
    void testHashmapifyCorrectMapping() {
        List<String> keys = List.of("apple", "banana", "cherry");
        List<Double> values = List.of(1.0, 2.0, 3.0);
        HashMap<String, Double> result = ZipUtils.hashmapify(keys, values);

        assertEquals(3, result.size());
        assertEquals(1.0, result.get("apple"));
        assertEquals(2.0, result.get("banana"));
        assertEquals(3.0, result.get("cherry"));
    }

    @Test
    void testHashmapifyThrowsExceptionOnMismatchedSizes() {
        List<String> keys = List.of("one", "two");
        List<Integer> values = List.of(1);

        assertThrows(IllegalArgumentException.class, () -> {
            ZipUtils.hashmapify(keys, values);
        });
    }

    @Test
    void testHashmapifyEmptyLists() {
        List<String> keys = List.of();
        List<Integer> values = List.of();
        HashMap<String, Integer> result = ZipUtils.hashmapify(keys, values);

        assertTrue(result.isEmpty());
    }
}
