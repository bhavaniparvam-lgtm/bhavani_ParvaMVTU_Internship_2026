package com.method_reference;
import java.util.*;
import java.util.function.*;

public class MethodRefToys {
    public static void main(String[] args) {
        List<String> toys = Arrays.asList("car", "doll", "ball");
        
        // 1. ✅ STATIC (Your example - PERFECT!)
        System.out.println("--- 1. STATIC ---");
        toys.forEach(System.out::println);
        
        // 2. ✅ PARTICULAR OBJECT (FIXED!)
        System.out.println("\n--- 2. PARTICULAR OBJECT ---");
        String myToy = "bike";
        Supplier<String> shoutToy = myToy::toUpperCase;  // Supplier = 0 params!
        System.out.println(shoutToy.get());  // BIKE
        
        // 3. ✅ ARBITRARY OBJECT (Your example - PERFECT!)
        System.out.println("\n--- 3. ARBITRARY ---");
        toys.sort(String::compareToIgnoreCase);
        toys.forEach(System.out::println);
    }
}