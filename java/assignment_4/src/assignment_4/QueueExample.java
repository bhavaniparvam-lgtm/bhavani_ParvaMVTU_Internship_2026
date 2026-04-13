package assignment_4;


import java.util.Queue;
import java.util.LinkedList;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println(queue);

        System.out.println(queue.peek());   // returns head, does not remove
        System.out.println(queue.poll());   // returns and removes head

        System.out.println(queue);

        for (Integer value : queue) {
            System.out.println(value);
        }
    }
}

