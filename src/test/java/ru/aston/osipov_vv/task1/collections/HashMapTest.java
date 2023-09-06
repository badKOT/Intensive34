package ru.aston.osipov_vv.task1.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.naming.InsufficientResourcesException;
import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    @Test
    void methods() {
        final int INIT_CAPACITY = 20;
        final float INIT_LOAD_FACTOR = 0.85F;
        HashMap<Integer, String> testMap = new HashMap<>(INIT_CAPACITY, INIT_LOAD_FACTOR);
        HashMap<Integer, String> map = new HashMap<>(testMap);
        map.put(1, "ONE");
        map.put(2, "TWO");
        map.put(3, "THREE");
        map.put(4, "FOUR");
        map.put(5, "FIVE");

        System.out.println(map.get(1));
        System.out.println(map.size());

        map.remove(1);
        System.out.println(map.isEmpty());

        System.out.println(map.containsKey(2));
        System.out.println(map.containsValue("SIX"));

        for (Map.Entry<Integer, String> entry : map.entrySet())
            System.out.print(entry + ", ");

        System.out.println(map.keySet());
        System.out.println(map.values());

        map.clear();
        System.out.println(map.isEmpty());
    }

    @Test
    void put() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "ONE");
        Assertions.assertFalse(map.isEmpty());
    }

    @Test
    void get() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "ONE");
        Assertions.assertEquals("ONE", map.get(1));
        Assertions.assertEquals(null, map.get(3));
    }

    @Test
    void size() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "ONE");
        map.put(2, "TWO");
        Assertions.assertEquals(2, map.size());
    }

    @Test
    void remove() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "ONE");
        map.put(2, "TWO");
        map.remove(2);
        Assertions.assertEquals(1, map.size());
    }

    @Test
    void isEmpty() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "ONE");
        Assertions.assertFalse(map.isEmpty());
    }

    @Test
    void containsKey() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "ONE");
        Assertions.assertTrue(map.containsKey(1));
        Assertions.assertFalse(map.containsKey(4));
    }

    @Test
    void containsValue() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "ONE");
        Assertions.assertTrue(map.containsValue("ONE"));
        Assertions.assertFalse(map.containsValue("TWO"));
    }

    @Test
    void entrySet() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "ONE");
        map.put(2, "TWO");
        map.put(3, "THREE");
        map.put(4, "FOUR");
        Assertions.assertEquals(4, map.entrySet().size());
    }

    @Test
    void keySet() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "ONE");
        map.put(2, "TWO");
        map.put(3, "THREE");
        map.put(4, "FOUR");
        Assertions.assertEquals(4, map.keySet().size());
    }

    @Test
    void values() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "ONE");
        map.put(2, "TWO");
        map.put(3, "THREE");
        map.put(4, "FOUR");
        Assertions.assertEquals(4, map.values().size());
    }

    @Test
    void clear() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "ONE");
        map.put(2, "TWO");
        map.put(3, "THREE");
        map.put(4, "FOUR");

        map.clear();
        Assertions.assertTrue(map.isEmpty());
    }
}
