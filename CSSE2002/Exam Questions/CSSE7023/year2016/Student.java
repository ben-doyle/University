package CSSE7023.year2016;

import java.util.ArrayList;

public class Student {
    private int studentId;
    private ArrayList<String> preferences;

    public Student(int studentId) {
        this.studentId = studentId;
        preferences = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public ArrayList<String> getPreferences() {
        return preferences;
    }

    public void addAll (ArrayList<String> morePreferences) {
        for (String preference : morePreferences) {
            if (!preferences.contains(preference)) {
                preferences.add(preference);
            }
        }
    }

    public String toString() {
        String result = studentId + ":";
        for (int i=0; i < preferences.size() ; i++) {
            result = result + " " + preferences.get(i);
        }
        return result;
    }

}
