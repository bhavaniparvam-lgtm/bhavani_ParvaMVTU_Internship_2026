package com.map;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class MapInterface {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Hello");
        map.put(2, "Hello");
        map.put(3, "Callahan");
        map.put(4, "Hello");
        map.put(null, "Hello");
        map.put(null, "Declan");   // replaces previous null key value
        map.put(1, "Rowan");       // replaces previous value for key 1

        System.out.println(map);

        map.forEach((k, v) -> System.out.println(k + " -> " + v));

        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        for (Map.Entry<Integer, String> keyValue : entrySet) {
            System.out.println(keyValue);
        }

        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            System.out.println(key + " " + map.get(key));
        }
    }
}