package tut8;


public class Y extends X {
    public void dot() {
        msg += "dot";
    }

    public String join(Y y) {
        return msg + "//" + y.toString();
    }
}

