package Polymorphism.year2008;

public class Question1c {
    public static void main(String[] args) {
        Object o = new B();
        A a1 = new B();
        A a2 = new B();

        a2.report(o);
        a1.report("test");
    }
}

class A {
    public void report(Object o ) {
        System.out.println("Object");
    }

    public void report(A a) {
        System.out.println("A");
    }

    public void report(String s) {
        System.out.println("A" + s);
    }
}

class B extends A {
    public void report (Object o ) {
        System.out.println("Object B");
    }
    public void report(A a) {
        System.out.println("A again");
    }

    public void report(B b) {
        System.out.println("B");
    }

    public void report(String s) {
        System.out.println(s);
    }
}