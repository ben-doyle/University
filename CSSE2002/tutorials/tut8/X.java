package tut8;

public class X {
    String msg = "";
    public void dot() {
        msg += ".";
    }
    public String join(X x) {
        return msg + "/" + x.toString();
    }
    public String toString() {
        return msg;
    }
}
