public class SelectionSort {

    public static int[] doSelectionSort(int[] arr) {
        int smallest = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[i] && arr[j] < arr[smallest]) {
                    smallest = j;
                }
            }
            if (!(smallest == i)) {
                int tmp = arr[i];
                arr[i] = arr[smallest];
                arr[smallest] = tmp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 34, 2, 56, 7, 67, 88, 42};
        int[] arr2 = doSelectionSort(arr1);
        for (int i : arr2) {
            System.out.print(i);
            System.out.print(", ");
        }
    }
}
