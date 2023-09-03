package ru.aston.osipov_vv.task1.collections;

import org.junit.jupiter.api.Test;
import ru.aston.osipov_vv.task1.entities.User;

import java.util.Arrays;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest {

    @Test
    void constructors() {
        // empty tree set with default comparator
        TreeSet<User> set = new TreeSet<>();

        // tree set built on top of collection with default comparator
        set = new TreeSet<>(set);

        // empty tree set with custom Comparator
        Comparator<User> comparator = (o1, o2) -> o1.getLastName().compareTo(o2.getLastName());
        set = new TreeSet<>(comparator);

        // tree set built on top of SortedSet with the same comparator
        SortedSet<User> sortedSet = new TreeSet<>();
        set = new TreeSet<>(sortedSet);
    }

    @Test
    void methods() {
        TreeSet<Integer> set = new TreeSet<>();
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
}
