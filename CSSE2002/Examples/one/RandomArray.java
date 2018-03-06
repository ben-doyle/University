package one;

import java.util.ArrayList;
import java.util.List;

public class RandomArray {

    public int[] RandomArray(int size) {

        int[] ReturnArray = new int[size];
        List<Integer> UsedNumbers = new ArrayList<>();
        int n;

        for (int i = 0; i < size; ) {
            n = (int) (Math.random() * 10);
            if (!UsedNumbers.contains(n) && n <= size-1) {
                UsedNumbers.add(n);
                ReturnArray[i] = n;
                i++;
            }
        }
        return ReturnArray;
    }
}