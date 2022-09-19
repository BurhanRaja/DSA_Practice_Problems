import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        // int[] arr = { 6, 5, 9, 3, 7, 1, 2, 8, 4 };
        int[] arr = {0, 2, 1, 2, 0};
        int[] ans = selectionSort(arr);
        System.out.println(Arrays.toString(ans));
    }

    static int[] selectionSort(int[] arr) {
        int end = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            int maxNum = maxNum(arr, end);
            swap(arr, maxNum, end);
            end--;
        }

        return arr;
    }

    static int maxNum(int[] arr, int end) {
        int max = 0;
        for (int i = 0; i <= end; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
