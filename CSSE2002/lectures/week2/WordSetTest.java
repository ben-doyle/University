package week2;

public class WordSetTest {

    public static void main(String[] args) {
        WordSet w = new WordSet();
        w.add("cat");
        w.add("dog");
        w.add("cat");
        // System.out.println(w.size());
        // System.out.println(w.contains("dog"));
        System.out.println(w);
    }

}
