package strings_java;

public class AllStringMethods {
	 public static void main(String[] args) {
	        String text = "  Hello World! Java Programming  ";
	        String[] words = text.trim().split("\\s+");

	        // Essential
	        System.out.println("1. length(): " + text.length());                    // 32
	        System.out.println("2. charAt(6): '" + text.charAt(6) + "'");           // 'W'

	        // Extract
	        System.out.println("3. substring(3): '" + text.substring(3) + "'");     // "lo World! Java Programming  "
	        System.out.println("4. substring(3,8): '" + text.substring(3,8) + "'"); // "lo Wo"
	        System.out.println("5. split(' '): " + java.util.Arrays.toString(words)); // [Hello, World!, Java, Programming]

	        // Case
	        System.out.println("6. toUpperCase(): '" + text.toUpperCase() + "'");   
	        System.out.println("7. toLowerCase(): '" + text.toLowerCase() + "'");   

	        // Clean
	        System.out.println("8. trim(): '" + text.trim() + "'");                 // "Hello World! Java Programming"

	        // Modify
	        System.out.println("9. concat(' Fun!'): '" + text.trim().concat(" Fun!") + "'"); 
	        System.out.println("10. replace('o','*'): '" + text.replace('o', '*') + "'"); 
	        System.out.println("11. replaceFirst('l','L'): '" + text.replaceFirst("l", "L") + "'");

	        // Search & Compare
	        System.out.println("12. equals(\"Hello\"): " + text.equals("Hello"));                    // false
	        System.out.println("13. equalsIgnoreCase(\"hello\"): " + text.equalsIgnoreCase("hello")); // true
	        System.out.println("14. startsWith(\"  H\"): " + text.startsWith("  H"));                // true
	        System.out.println("15. endsWith(\"ming  \"): " + text.endsWith("ming  "));             // true
	        System.out.println("16. contains(\"Java\"): " + text.contains("Java"));                  // true
	        System.out.println("17. indexOf(\"World\"): " + text.indexOf("World"));                  // 7
	        System.out.println("18. lastIndexOf(\"a\"): " + text.lastIndexOf("a"));                  // 27
	        System.out.println("19. compareTo(\"abc\"): " + text.compareTo("abc"));                  // positive

	        // Advanced
	        System.out.println("20. matches(\"^\\s.*\\s$\"): " + text.matches("^\\s.*\\s$"));        // true (starts/ends with space)
	        System.out.println("21. replaceAll(\"\\s+\", \"_\"): '" + text.replaceAll("\\s+", "_") + "'"); 
	        System.out.println("22. isEmpty(): " + "".isEmpty());                                    // true
	        System.out.println("23. isBlank(): " + "   ".isBlank());                                 // true (Java 11+)
	    }
}
