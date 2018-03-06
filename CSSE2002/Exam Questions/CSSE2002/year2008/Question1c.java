package CSSE2002.year2008;

public class Question1c {
    public static void main(String[] args) {
        Object o = new A();
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        a2.report(a1);
        a2.report(b);
        b.report(o);
        b.report(a2);
    }

    static class A {
        public void report (Object o) {
            System.out.println("Object");
        }

        public void report(A a) {
            System.out.println("A");
        }
    }

    static class B extends A {
        public void report(A a) {
            System.out.println("A again");
        }

        public void report(B b) {
            System.out.println("B");
        }
    }
}
