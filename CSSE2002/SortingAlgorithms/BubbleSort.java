public final class BubbleSort {
    public static int[] bubbleSort(int[] arr1) {
        int last = arr1.length - 1;
        while (last > 0 ) {
            for (int i = 0; i < arr1.length - 1 ; i++) {
                if (arr1[i + 1] < arr1[i]) {
                    int tmp = arr1[i];
                    arr1[i] = arr1[i + 1];
                    arr1[i + 1] = tmp;
                }
            }
            last--;
        }
        return arr1;
    }
}
