package week7;

public class EmptyException extends RuntimeException {

    public EmptyException() {
        super();
    }

    public EmptyException(String s) {
        super(s);
    }
}