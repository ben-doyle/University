package Polymorphism.year2006;

public class Question1C {
    public static void main (String[] args) {
        Object o = new A();
        A a1 = new A();
        A a2 = new AX();
        AX ax = new AX();
        System.out.println(a1.method(o));  // 1
        System.out.println(a2.method(a1)); // 3
        System.out.println(a2.method(o));  // 1
        System.out.println(a2.method(ax)); // 3
    }
}

class A {
    public int method(Object o) {
        return 1;
    }

    public int method(A a) {
        return 2;
    }

}

class AX extends A {
    public int method(A a) {
        return 3;
    }

    public int method(AX ax) {
        return 4;
    }
}
