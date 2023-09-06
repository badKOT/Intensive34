package ru.aston.osipov_vv.task1.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class ArrayListTest {

    @Test
    void methods() {
        ArrayList<Integer> list = new ArrayList<>();
        final int INIT_CAPACITY = 18;
        list = new ArrayList<>(INIT_CAPACITY);
        List<Integer> testList = List.of(1, 2, 3, 4, 5);

        list.addAll(testList);
        list.clear();

        int testNumber = 8;
        list.add(testNumber);

        list.addAll(testList);
        int testIndex = 3;
        System.out.println(list.get(testIndex));

        System.out.println(list.size());
        System.out.println(list.isEmpty());

        System.out.println(list.contains(8));
        System.out.println(list.indexOf(testNumber));
        list.remove(8);
        list.remove(8);
    }

    @Test
    void addAll() {
        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> testList = List.of(1, 2, 3, 4, 5);
        list.addAll(testList);
        Assertions.assertEquals(list, testList);
    }

    @Test
    void clear() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.clear();
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    void add() {
        ArrayList<Integer> list = new ArrayList<>();
        final int TEST_ELEM = 13;
        list.add(TEST_ELEM);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void get() {
        ArrayList<Integer> list = new ArrayList<>();
        final int TEST_CAPACITY = 5;
        for (int i = 1; i < TEST_CAPACITY; i++)
            list.add(i);
        Assertions.assertEquals(3, list.get(2));
    }

    @Test
    void size() {
        ArrayList<Integer> list = new ArrayList<>();
        final int TEST_CAPACITY = 5;
        for (int i = 0; i < TEST_CAPACITY; i++)
            list.add(i);
        Assertions.assertEquals(5, list.size());
    }

    @Test
    void isEmpty() {
        ArrayList<Integer> list = new ArrayList<>();
        final int TEST_ELEM = 13;
        list.add(TEST_ELEM);
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    void contains() {
        ArrayList<Integer> list = new ArrayList<>();
        final int TEST_ELEM = 8;
        final int TEST_JUMP = 10;
        final int TEST_SIZE = 5;
        for (int i = 0; i < TEST_SIZE; i++)
            list.add(TEST_ELEM + i * TEST_JUMP);
        Assertions.assertTrue(list.contains(28));
    }

    @Test
    void indexOf() {
        ArrayList<Integer> list = new ArrayList<>();
        final int TEST_ELEM = 8;
        final int TEST_JUMP = 10;
        final int TEST_SIZE = 5;
        for (int i = 0; i < TEST_SIZE; i++)
            list.add(TEST_ELEM + i * TEST_JUMP);
        Assertions.assertEquals(2, list.indexOf(28));
    }

    @Test
    void remove() {
        ArrayList<Integer> list = new ArrayList<>();
        final int TEST_ELEM = 8;
        list.add(TEST_ELEM);
        list.remove(0);
        Assertions.assertTrue(list.isEmpty());
    }
}
