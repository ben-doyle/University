package CSSE7023.year2016;

import java.util.ArrayList;

public class Question1b {

    public static void main(String[] args) {
        Student s1 = new Student(1);
        Student s2 = new Student(2);
        Student s3 = new Student(3);

        ArrayList<String> preferences = new ArrayList<>();
        preferences.add("COMP3301");
        preferences.add("COMP3506");
        s1. addAll(preferences);

        preferences.add("COMP4702");
        s2.addAll(preferences);

        preferences = s1.getPreferences();
        preferences.remove("COMP3506");
        s3.addAll(preferences);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

    }
}
