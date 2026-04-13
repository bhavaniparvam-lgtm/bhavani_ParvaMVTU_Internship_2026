package com.functional_interface;
@FunctionalInterface
interface MyInterface {
    void display();
}

public class FuncInterfaceDemo {
    public static void main(String[] args) {
        MyInterface mi = () -> System.out.println("Hello Functional Interface");
        mi.display();
    }
}


