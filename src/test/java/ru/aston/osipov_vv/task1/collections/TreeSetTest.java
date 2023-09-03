package ru.aston.osipov_vv.task1.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.aston.osipov_vv.task1.entities.User;

import java.util.*;

public class TreeSetTest {

    @Test
    void methods() {
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(
                o1.toString().charAt(0), o2.toString().charAt(0));
        TreeSet<Integer> set = new TreeSet<>(comparator);
        set.add(5);
        set.addAll(Arrays.asList(1, 2, 3, 7, 8, 9));

        System.out.println(set.ceiling(5));
        System.out.println(set.floor(5));
        System.out.println(set.higher(5));
        System.out.println(set.lower(5));

        System.out.println(set.contains(4));
        System.out.println(set.first());
        System.out.println(set.last());
        System.out.println(set.pollFirst());
        System.out.println(set.pollLast());
        System.out.println(set);
        System.out.println();
    }

    @Test
    void add() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(8);
        set.add(3);
        Assertions.assertFalse(set.isEmpty());
    }

    @Test
    void ceiling() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(8);
        set.add(3);
        Assertions.assertEquals(5, set.ceiling(5));
        Assertions.assertEquals(8, set.ceiling(6));
    }

    @Test
    void floor() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(8);
        set.add(3);
        Assertions.assertEquals(5, set.floor(5));
        Assertions.assertEquals(3, set.floor(4));
    }

    @Test
    void higher() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(8);
        set.add(3);
        Assertions.assertEquals(8, set.higher(5));
    }

    @Test
    void lower() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(8);
        set.add(3);
        Assertions.assertEquals(3, set.lower(5));
    }

    @Test
    void contains() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(8);
        set.add(3);
        Assertions.assertTrue(set.contains(3));
        Assertions.assertFalse(set.contains(4));
    }

    @Test
    void first() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(8);
        set.add(3);
        Assertions.assertEquals(3, set.first());
    }

    @Test
    void pollFirst() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(8);
        set.add(3);
        set.pollFirst();
        Assertions.assertEquals(5, set.first());
    }

    @Test
    void pollLast() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(8);
        set.add(3);
        set.pollLast();
        Assertions.assertEquals(5, set.last());
    }
}
