import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.printf("Please enter a random array size: ");
        int size = s.nextInt();

        int[] arr1 = randomInts(size);
        long startTime = System.currentTimeMillis();
        int[] arr2 = BubbleSort.bubbleSort(arr1);
        long endTime = System.currentTimeMillis();

        System.out.println("An Array of size: " + size + " took "
                + (endTime - startTime) + " milliseconds to completely sort");

//        System.out.println("Sorted list is:");
//        for (int i : arr2) {
//            System.out.print(i);
//            System.out.print(", ");
//        }

    }

    private static int[] randomInts(int size) {
        int[] returnArray = new int[size];
        for (int i = 0; i < size; i++) {
            returnArray[i] = (int) (Math.random() * 100);
        }
        return returnArray;
    }

    private static String logTime(int size, int milliseconds) {
        return "";
    }
}
