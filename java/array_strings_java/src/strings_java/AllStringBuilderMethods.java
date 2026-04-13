package strings_java;

public class AllStringBuilderMethods {
	public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        
        // 1. Basic inspection
        System.out.println("1. length(): " + sb.length());           // 5
        System.out.println("2. capacity(): " + sb.capacity());       // 21 (16+5)
        System.out.println("3. charAt(1): '" + sb.charAt(1) + "'");  // 'e'
        
        // 4. Modify single char
        sb.setCharAt(1, 'a');
        System.out.println("4. setCharAt: " + sb);                  // "Hallo"
        
        // 5. Append (most common)
        sb.append(" World!");
        System.out.println("5. append: " + sb);                     // "Hallo World!"
        
        // 6. Insert
        sb.insert(5, "Beautiful ");
        System.out.println("6. insert: " + sb);                     // "HalloBeautiful World!"
        
        // 7. Replace range
        sb.replace(5, 15, "Java ");
        System.out.println("7. replace: " + sb);                    // "HalloJava World!"
        
        // 8. Delete range
        sb.delete(5, 11);
        System.out.println("8. delete: " + sb);                     // "HalloWorld!"
        
        // 9. Delete single char
        sb.deleteCharAt(5);
        System.out.println("9. deleteCharAt: " + sb);               // "Halloorld!"
        
        // 10. Reverse
        sb.reverse();
        System.out.println("10. reverse: " + sb);                   // "!droollah"
        
        // 11. Extract substring (doesn't modify original)
        String sub = sb.substring(3, 7);
        System.out.println("11. substring: '" + sub + "'");         // "ooll"
        
        // 12. Set length (trim or grow)
        sb.setLength(8);
        System.out.println("12. setLength(8): '" + sb + "'");       // "!drool"
        
        // 13. Ensure capacity
        sb.ensureCapacity(100);
        System.out.println("13. capacity now: " + sb.capacity());   // >=100
        
        // 14. Convert to String
        String result = sb.toString();
        System.out.println("14. toString(): '" + result + "'");     // "!drool"
    }
}
