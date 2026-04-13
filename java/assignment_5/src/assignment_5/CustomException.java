package assignment_5;


class UnderAgeException extends Exception {
    UnderAgeException(String msg) {
        super(msg);
    }
}

public class CustomException {
    public static void main(String[] args) {
        try {
            checkAge(16);
        } catch (UnderAgeException e) {
            System.out.println(e.getMessage());
        }
    }

    static void checkAge(int age) throws UnderAgeException {
        if (age < 18) {
            throw new UnderAgeException("Not eligible");
        }
    }
}