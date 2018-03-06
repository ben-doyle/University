package tut1;

public class Loops {

    public static void main(String[] args) {

        //FOR LOOP EXAMPLES
        /*
         * for each example
         */
        int[] a = {1, 2 ,3, 5, 8};
        for (int v : a) { //for each int v, in the array a
            System.out.println(v);
        }

        /*
         * same as
         */
        for (int i = 0; i <a.length; i++) {
            int v = a[i];
            System.out.println(v);
        }
    }
}
