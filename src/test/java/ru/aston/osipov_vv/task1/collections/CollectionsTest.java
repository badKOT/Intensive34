package ru.aston.osipov_vv.task1.collections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class CollectionsTest {

    @Test
    void methods() {
        ArrayList<Integer> list = new ArrayList<>(
                Arrays.asList(1, 5, 18, 2, 12, 8, 16, 11, 17, 15, 9, 7, 4, 19));
        Collections.sort(list);
        System.out.println(list);
        int v = Collections.indexOfSubList(list, Arrays.asList(5, 7, 8));
        System.out.println(list.get(v));

        Collections.shuffle(list);
        System.out.println(list);
        v = Collections.indexOfSubList(list, Arrays.asList(6, 7, 8));
        System.out.println(v);

        Collections.reverse(list);
        System.out.println(list);
        System.out.println(Collections.min(list));

        System.out.println(Collections.binarySearch(list, 8));
        System.out.println(Collections.binarySearch(list, 6));

        Collections.fill(list, 5);
        System.out.println(list);
        System.out.println(Collections.replaceAll(
                list, 5, new Random().nextInt(30)));
    }
}
