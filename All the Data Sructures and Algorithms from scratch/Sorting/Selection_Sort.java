
import java.util.Arrays;

public class Selection_Sort {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 4, 5, 2 };
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // To select the maximum and swap it with the last element and decreasing the length of the array
    static void selectionSort(int[] arr) {
        int n = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            int maxNum = getMax(arr, n);
            swap(arr, maxNum, n);
            n--;
        }
    }

    static int getMax(int[] arr, int n) {
        int max = 0;
        for (int i = 0; i <= n; i++) {
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
