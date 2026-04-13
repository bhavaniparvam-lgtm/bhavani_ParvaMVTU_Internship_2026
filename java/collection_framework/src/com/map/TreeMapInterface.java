package com.map;


import java.util.Map;
import java.util.TreeMap;
import java.util.Set;

public class TreeMapInterface {
    public static void main(String[] args) {
        Map<Integer, String> map = new TreeMap<>();

        map.put(1, "Hello");
        map.put(2, "Hello");
        map.put(3, "Callahan");
        map.put(4, "Hello");

        // TreeMap does not allow null keys
        // map.put(null, "Hello");  // This will throw NullPointerException

        map.put(1, "Rowan"); // replaces key 1 value

        System.out.println(map);

        map.forEach((k, v) -> System.out.println(k + " -> " + v));

        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();-
        for (Map.Entry<Integer, String> keyValue : entrySet) {
            System.out.println(keyValue);
        }

        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
