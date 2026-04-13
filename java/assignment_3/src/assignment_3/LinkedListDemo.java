package assignment_3;


import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListDemo {
    public static void main(String[] args) {
        // 1. Create a LinkedList of Strings
        LinkedList<String> fruits = new LinkedList<>();

        // 2. Add elements
        fruits.add("Apple");          // Add at end
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.addFirst("Guava");     // Add at beginning
        fruits.addLast("Mango");      // Add at end
        fruits.add(2, "Papaya");      // Add at index 2

        System.out.println("Fruits List: " + fruits);

        // 3. Remove elements
        fruits.remove();              // Remove first element
        fruits.remove(3);             // Remove element at index 3
        fruits.remove("Banana");      // Remove specific element

        System.out.println("After Removing Elements: " + fruits);

        // 4. Access elements
        System.out.println("First Fruit: " + fruits.getFirst());
        System.out.println("Last Fruit: " + fruits.getLast());
        System.out.println("Fruit at Index 1: " + fruits.get(1));

        // 5. Other useful methods
        System.out.println("List contains Mango? " + fruits.contains("Mango"));
        System.out.println("Size of List: " + fruits.size());

        // 6. Traversing LinkedList

        // Using for-each loop
        System.out.println("\nTraversal using for-each loop:");
        for(String fruit : fruits) {
            System.out.println(fruit);
        }

        // Using Iterator
        System.out.println("\nTraversal using Iterator:");
        Iterator<String> it = fruits.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        // Using ListIterator (bi-directional)
        System.out.println("\nTraversal using ListIterator:");
        var lit = fruits.listIterator();
        System.out.println("Forward:");
        while(lit.hasNext()) {
            System.out.println(lit.next());
        }
        System.out.println("Backward:");
        while(lit.hasPrevious()) {
            System.out.println(lit.previous());
        }

        // 7. Clear the list
        fruits.clear();
        System.out.println("\nAfter clearing, is list empty? " + fruits.isEmpty());
    }
}

