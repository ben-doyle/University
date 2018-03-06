public final class InsertionSort {

    /**
     * Insertion sort example
     *
     * @param arr1 Array of ints to be sorted.
     * @return Array of ints sorted lexicographically
     */
    public static int[] doInsertionSort(int[] arr1) {
        int i;
        int j;
        for (i = 1; i < arr1.length; i++) {
            j = i;
            while ((j > 0) && (arr1[j] < arr1[j-1])) {
                int tmp = arr1[j];
                arr1[j] = arr1[j-1];
                arr1[j-1] = tmp;
                j = j-1;
            }
        }
        return arr1;
    }
}
