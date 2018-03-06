package CSSE7023.year2016;

public class Bar extends Foo implements Baz {

    public Bar(String a) {
        super(a);
    }

    public void combine(Bar bar) {
        this.a = "(" + bar.toString() + ")" +
                "(" + this.toString() + ")";
    }

    public String toString() {
        return "Bar: " + a;
    }
}
