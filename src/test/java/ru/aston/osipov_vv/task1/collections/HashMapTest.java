package ru.aston.osipov_vv.task1.collections;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    @Test
    void constructors() {
        // empty hash map with initial capacity of 16 and load factor of .75
        HashMap<Integer, String> map = new HashMap<>();

        // empty hash map with specified initial capacity and default load factor
        final int INIT_CAPACITY = 20;
        map = new HashMap<>(INIT_CAPACITY);

        // empty hash map with specified initial capacity and load factor
        final float INIT_LOAD_FACTOR = 0.85F;
        map = new HashMap<>(INIT_CAPACITY, INIT_LOAD_FACTOR);

        // hash map built on top of another map
        HashMap<Integer, String> anotherMap = new HashMap<>(map);
    }

    @Test
    void methods() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "ONE");
        map.put(2, "TWO");
        map.put(3, "THREE");
        map.put(4, "FOUR");
        map.put(5, "FIVE");

        System.out.println(map.get(1)); // "ONE" (or null if the key is absent)
        System.out.println(map.size()); // 5

        map.remove(1);
        System.out.println(map.isEmpty()); // false

        System.out.println(map.containsKey(2)); // true
        System.out.println(map.containsValue("SIX")); // false

        // 1="ONE", 2="TWO", 3="THREE", 4="FOUR", 5="FIVE"
        for (Map.Entry<Integer, String> entry : map.entrySet())
            System.out.print(entry + ", ");

        System.out.println(map.keySet()); // 1, 2, 3, 4, 5
        System.out.println(map.values()); // "ONE", "TWO", "THREE", "FOUR", "FIVE"

        map.clear();
        System.out.println(map.isEmpty()); // true
    }
}
