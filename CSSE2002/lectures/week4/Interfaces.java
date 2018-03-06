package week4;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;

public class Interfaces {

    public static void main(String[] args)
            throws CloneNotSupportedException {
        // Iterable
        WordSet w = new WordSet();
        w.add("cat");
        w.add("dog");

        Iterator<String> it = w.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        for (String word : w) {
            System.out.println(word);
        }

        // Comparable
        Name n1 = new Name("Douglas", "Alves Peixoto");
        Name n2 = new Name("Bethany", "Cave");
        Name n3 = new Name("Chelsea", "Edmonds");
        Name n4 = new Name("Justin", "Goldizen");
        Name n5 = new Name("Aiden", "Goldthorpe");

        System.out.println(n2.compareTo(n1));
        System.out.println(n2.compareTo(n3));
        System.out.println(n1.compareTo(n4));

        ArrayList<Name> names = new ArrayList<Name>();
        names.add(n1);
        names.add(n2);
        names.add(n3);
        names.add(n4);
        names.add(n5);
        Collections.sort(names);
        System.out.println(names);

        // Cloneable
        WordSet w1 = (WordSet) w.clone();
        System.out.println(w1);
        System.out.println(w.equals(w1));

        Name n6 = (Name) n1.clone();
        System.out.println(n6);
        System.out.println(n1.equals(n6));
    }
}
