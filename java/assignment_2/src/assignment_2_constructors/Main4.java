package assignment_2_constructors;
class Book {
    String title;
    String author;
    double price;
    boolean available;

    // No‑arg constructor: set default values
    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
        this.available = true;
    }

    // 2‑param constructor: title and author
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.price = 0.0;
        this.available = true;
    }

    // 4‑param constructor: all four variables
    public Book(String title, String author, double price, boolean available) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = available;
    }

    // showInfo() method: print all variables in a neat format
    public void showInfo() {
        System.out.println("Title   : " + title);
        System.out.println("Author  : " + author);
        System.out.println("Price   : $" + price);
        System.out.println("Available: " + (available ? "Yes" : "No"));
        System.out.println(); // empty line for readability
    }
}

public class Main4 {
    public static void main(String[] args) {
        // Create 3 objects using different constructors
        Book b1 = new Book();                                   // no‑arg
        Book b2 = new Book("The Java Handbook", "Mark Allen");  // 2‑param
        Book b3 = new Book("Advanced Java", "Sara Lee", 39.99, true); // 4‑param

        // Call showInfo() on each
        b1.showInfo();
        b2.showInfo();
        b3.showInfo();
    }
}


