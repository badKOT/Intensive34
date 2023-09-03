package ru.aston.osipov_vv.task1.collections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListTest {

    @Test
    void constructors() {
        // empty list with initial capacity of ten
        ArrayList<Integer> list = new ArrayList<>();

        // empty list with specified initial capacity
        final int INIT_CAPACITY = 18;
        list = new ArrayList<>(INIT_CAPACITY);

        // list built on top of another collection
        list = new ArrayList<>(list);
    }

    @Test
    void methods() {
        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> testList = List.of(1, 2, 3, 4, 5);

        list.addAll(testList); // [1, 2, 3, 4, 5]
        list.clear(); // []

        int testNumber = 8;
        list.add(testNumber); // [8]

        list.addAll(testList);
        int testIndex = 3;
        System.out.println(list.get(testIndex)); // 3

        System.out.println(list.size()); // 6
        System.out.println(list.isEmpty()); // false

        System.out.println(list.contains(8)); // true
        System.out.println(list.indexOf(testNumber)); // 0
        list.remove(8);
        list.remove(8);
    }
}
