import java.util.ArrayList;

public class Cartesian {
    public static void main(String[] args) {
        ArrayList<String> ar1 = new ArrayList<>();
        ar1.add("one");
        ar1.add("two");
        ar1.add("three");

        ArrayList<String> ar2 = new ArrayList<>();
        ar2.add("ono");
        ar2.add("duo");
        ar2.add("tre");
        ar2.add("Quatrro");

        ArrayList<ArrayList<String>> temp = new ArrayList<>();
        temp.add(ar1);
        temp.add(ar2);

        cartesianProduct(temp, 0, new String[temp.size()]);
    }

    private static void cartesianProduct(ArrayList<ArrayList<String>> arr, int level, String[] cp) {
        if (level == arr.size()) {
            for (String x : cp)
                System.out.print(x + " ");
            System.out.println();
            return;
        }

        for (int i = 0; i < arr.get(level).size(); i++) {
            cp[level] = arr.get(level).get(i);
            cartesianProduct(arr, level + 1, cp);
        }
    }
}

