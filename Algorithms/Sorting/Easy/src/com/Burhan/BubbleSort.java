import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 6, 5, 9, 3, 7, 1, 2, 8, 4 };
        int[] ans = bubbleSortOpt(arr);
        System.out.println(Arrays.toString(ans));
    }

    static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }

        return arr;
    }

    // Optimized Bubble Sort
    static int[] bubbleSortOpt(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return arr;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
