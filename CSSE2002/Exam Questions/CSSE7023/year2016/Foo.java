package CSSE7023.year2016;

public class Foo {
    protected String a;

    public Foo(String a) {
        this.a = a;
    }

    public void combine(Foo foo) {
        this.a = "(" + this.toString() + ")" +
                "(" + foo.toString() + ")";
    }

    public String toString() {
        return "Foo: " + a;
    }
}

