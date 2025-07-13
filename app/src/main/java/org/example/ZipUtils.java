package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZipUtils {

    public static <T> List<T> zip(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<>();
        int size1 = list1.size();
        int size2 = list2.size();
        int minSize = Math.min(size1, size2);

        for (int i = 0; i < minSize; i++) {
            result.add(list1.get(i));
            result.add(list2.get(i));
        }

        if (size1 > minSize) {
            result.addAll(list1.subList(minSize, size1));
        } else if (size2 > minSize) {
            result.addAll(list2.subList(minSize, size2));
        }

        return result;
    }
    public static <V> HashMap<String, V> hashmapify(List<String> keys, List<V> values) {
        if (keys.size() != values.size()) {
            throw new IllegalArgumentException("Lists must be of equal size.");
        }

        HashMap<String, V> map = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            map.put(keys.get(i), values.get(i));
        }

        return map;
    }
}
