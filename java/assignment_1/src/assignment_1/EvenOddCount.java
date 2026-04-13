package assignment_1;


public class EvenOddCount {
    public static void main(String[] args) {
        int[] arr = {10, 20, 31, 40, 5};
        int even = 0, odd = 0;
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("Even: " + even + ", Odd: " + odd);
    }
}