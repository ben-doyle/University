package Polymorphism.year2013;

public class Question1B {
    public static void main(String[] args) {
        X x = new X();
        x.dot();
        Y y = new Y();
        y.dot();
        X y2 = new Y();
        y2.dot();
        System.out.println(x.join(x));
        System.out.println(y.join(y2));

    }
}

class X {
    String msg = "";
    public void dot() {
        msg += ".";
    }
    public String join (X x) {
        return msg + "/" + x.toString();
    }
    public String toString() {
        return msg;
    }
}

class Y extends X {
    public void dot() {
        msg += "dot";
    }
    public String join(Y y) {
        return msg + "//" + y.toString();
    }
}
